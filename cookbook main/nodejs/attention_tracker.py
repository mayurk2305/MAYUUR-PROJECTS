import cv2
import mediapipe as mp
import numpy as np
import time
import winsound  # For alert sound (Windows only)
import matplotlib.pyplot as plt

mp_face_mesh = mp.solutions.face_mesh
mp_drawing = mp.solutions.drawing_utils
mp_drawing_styles = mp.solutions.drawing_styles

def calculate_EAR(landmarks, eye_indices):
    p1 = np.array([landmarks[eye_indices[0]].x, landmarks[eye_indices[0]].y])
    p2 = np.array([landmarks[eye_indices[1]].x, landmarks[eye_indices[1]].y])
    p3 = np.array([landmarks[eye_indices[2]].x, landmarks[eye_indices[2]].y])
    p4 = np.array([landmarks[eye_indices[3]].x, landmarks[eye_indices[3]].y])
    p5 = np.array([landmarks[eye_indices[4]].x, landmarks[eye_indices[4]].y])
    p6 = np.array([landmarks[eye_indices[5]].x, landmarks[eye_indices[5]].y])

    vertical_dist1 = np.linalg.norm(p2 - p6)
    vertical_dist2 = np.linalg.norm(p3 - p5)
    horizontal_dist = np.linalg.norm(p1 - p4)

    EAR = (vertical_dist1 + vertical_dist2) / (2.0 * horizontal_dist)
    return EAR

def detect_gaze(landmarks, left_threshold, right_threshold):
    left_eye = np.array([landmarks[33].x, landmarks[33].y])
    right_eye = np.array([landmarks[362].x, landmarks[362].y])
    nose_tip = np.array([landmarks[1].x, landmarks[1].y])

    eye_center = (left_eye + right_eye) / 2.0
    gaze_shift = eye_center[0] - nose_tip[0]

    if gaze_shift > right_threshold:
        return "Looking Right"
    elif gaze_shift < left_threshold:
        return "Looking Left"
    else:
        return "Looking Straight"

def compute_attention_score(look_away_time, blink_count, gaze_status, last_gaze_status, attention_score, side_glance_start):
    total_time = time.time() - start_time
    straight_time = total_time - look_away_time

    # Slower recovery and decrease rates
    if gaze_status == "Looking Straight":
        if attention_score > 50:
            attention_score = min(attention_score + 0.1, 100)  # Slower recovery above 50
        else:
            attention_score = min(attention_score + 0.2, 100)  # Recovery is still slower
    elif gaze_status in ["Looking Left", "Looking Right"]:
        if side_glance_start is None:
            side_glance_start = time.time()
        elapsed_side_time = time.time() - side_glance_start
        attention_score = max(attention_score - elapsed_side_time * 0.05, 0)  # Slow decrease for side glances
    else:
        attention_score = max(attention_score - 0.1, 0)  # Slow decrease when looking away

    return max(attention_score, 0), side_glance_start

# Blink tracking
blink_count = 0
look_away_time = 0
gaze_away_start = None
blink_start = None
attention_score = 100
start_time = time.time()
side_glance_start = None
last_gaze_status = "Looking Straight"

blink_threshold = 0.25
right_threshold = 0.03
left_threshold = -0.05

blink_rate_threshold = 12  # Allow up to 12 blinks per minute
blink_time_window = 60  # Time window for blink rate (in seconds)
blinks_in_last_window = 0
last_blink_time_check = time.time()

attention_scores = []
gaze_logs = []
blink_logs = []

cap = cv2.VideoCapture(0)

with mp_face_mesh.FaceMesh(
    max_num_faces=1,
    refine_landmarks=True,
    min_detection_confidence=0.5,
    min_tracking_confidence=0.5) as face_mesh:

    while True:
        ret, frame = cap.read()
        frame_rgb = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
        results = face_mesh.process(frame_rgb)

        if results.multi_face_landmarks:
            for face_landmarks in results.multi_face_landmarks:
                landmarks = face_landmarks.landmark

                right_eye_indices = [33, 160, 158, 133, 153, 144]
                left_eye_indices = [362, 385, 387, 263, 373, 380]

                right_EAR = calculate_EAR(landmarks, right_eye_indices)
                left_EAR = calculate_EAR(landmarks, left_eye_indices)
                avg_EAR = (right_EAR + left_EAR) / 2.0

                if avg_EAR < blink_threshold and blink_start is None:
                    blink_start = time.time()
                elif avg_EAR > blink_threshold and blink_start:
                    blink_count += 1
                    blinks_in_last_window += 1
                    blink_logs.append(time.time() - start_time)
                    blink_start = None

                if time.time() - last_blink_time_check > blink_time_window:
                    if blinks_in_last_window > blink_rate_threshold:
                        attention_score = max(attention_score - 5, 0)  # Penalty for excessive blinking
                    blinks_in_last_window = 0
                    last_blink_time_check = time.time()

                gaze_status = detect_gaze(landmarks, left_threshold, right_threshold)
                cv2.putText(frame, f'Gaze: {gaze_status}', (30, 90), cv2.FONT_HERSHEY_SIMPLEX, 1, (255, 0, 0), 2)

                if gaze_status not in ["Looking Straight", "Looking Left", "Looking Right"] and gaze_away_start is None:
                    gaze_away_start = time.time()
                elif gaze_status in ["Looking Straight", "Looking Left", "Looking Right"] and gaze_away_start:
                    look_away_time += time.time() - gaze_away_start
                    gaze_away_start = None

                attention_score, side_glance_start = compute_attention_score(
                    look_away_time, blink_count, gaze_status, last_gaze_status, attention_score, side_glance_start
                )
                last_gaze_status = gaze_status
                attention_scores.append(attention_score)
                gaze_logs.append((time.time() - start_time, gaze_status))

                if attention_score < 50:
                    winsound.Beep(1000, 500)

                cv2.putText(frame, f'Attention Score: {attention_score:.0f}', (30, 120), cv2.FONT_HERSHEY_SIMPLEX, 1, (255, 255, 0), 2)

                mp_drawing.draw_landmarks(
                    image=frame,
                    landmark_list=face_landmarks,
                    connections=mp_face_mesh.FACEMESH_TESSELATION,
                    landmark_drawing_spec=None,
                    connection_drawing_spec=mp_drawing_styles.get_default_face_mesh_tesselation_style())

        cv2.imshow('Attention Tracker', frame)

        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

cap.release()
cv2.destroyAllWindows()

with open('session_logs.txt', 'w') as f:
    f.write('Time, Gaze, Attention Score, Blink\n')
    for i, score in enumerate(attention_scores):
        gaze = gaze_logs[i][1]
        blink_time = blink_logs[i] if i < len(blink_logs) else 'N/A'
        f.write(f"{gaze_logs[i][0]:.2f}, {gaze}, {score:.2f}, {blink_time}\n")

plt.plot([log[0] for log in gaze_logs], attention_scores)
plt.xlabel('Time (s)')
plt.ylabel('Attention Score')
plt.title('Attention Score Over Time')
plt.show()
