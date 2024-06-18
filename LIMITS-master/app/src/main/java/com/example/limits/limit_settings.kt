package com.example.limits

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ViewCompat
import androidx.customview.widget.ViewDragHelper
import java.text.DateFormat
import java.util.Calendar

class LimitSettings : ComponentActivity() {

    private lateinit var selectedTimeButton: Button
    private lateinit var calendar: Calendar

    private lateinit var insertAmountButton: Button
    private lateinit var dragHelper: ViewDragHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.limit_aettings)

        // Initialize the button and calendar
        selectedTimeButton = findViewById(R.id.selectedTimeButton)
        calendar = Calendar.getInstance()

        // Set up click listener for the time button
        selectedTimeButton.setOnClickListener {
            showTimePickerDialog()
        }

        // Initialize the insertAmountButton and dragHelper
        insertAmountButton = findViewById(R.id.insertAmountButton)

        dragHelper = ViewDragHelper.create(findViewById(android.R.id.content), 1.0f, object : ViewDragHelper.Callback() {

            override fun tryCaptureView(child: View, pointerId: Int): Boolean {
                return child === insertAmountButton
            }

            override fun onViewReleased(releasedChild: View, xvel: Float, yvel: Float) {
                super.onViewReleased(releasedChild, xvel, yvel)
                animateToStartPosition(releasedChild)
            }
        })

        // Set up click listener for the insertAmountButton
        insertAmountButton.setOnClickListener {
            // Handle the click event for insertAmountButton
            showAmountInputDialog()
        }
        val game = findViewById<Button>(R.id.playgames);
        game.setOnClickListener {
            val context2 = this
            val targetActivity = games::class.java
            val intent = Intent(context2, targetActivity)
            startActivity(intent)
        }
    }

    private fun showTimePickerDialog() {
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
                // Handle the selected time
                calendar.set(Calendar.HOUR_OF_DAY, selectedHour)
                calendar.set(Calendar.MINUTE, selectedMinute)

                // Format the time and update the UI
                val timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT)
                val formattedTime = timeFormat.format(calendar.time)
                selectedTimeButton.text = formattedTime
            },
            hour,
            minute,
            false
        )

        timePickerDialog.show()
    }

    private fun showAmountInputDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Enter Amount")

        val input = EditText(this)
        input.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
        builder.setView(input)

        builder.setPositiveButton("OK") { _, _ ->
            val amountText = input.text.toString()
            if (amountText.isNotEmpty()) {
                val amount = amountText.toDouble()
                moveToNextActivity(amount)
            }
        }

        builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }

        builder.show()
    }

    private fun displayAmount(amount: Double) {
        // Update your UI to display the amount
        // For example, you can set it to a TextView or any other UI element
        // For now, let's assume you have a TextView with the id amountTextView
        val amountTextView: TextView = findViewById(R.id.resultTextView)
        amountTextView.text = String.format("Amount: ₹ %.2f", amount)
    }

    private fun animateToStartPosition(view: View) {
        if (dragHelper.smoothSlideViewTo(view, 0, 0)) {
            ViewCompat.postOnAnimation(view, SettleRunnable(view))
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        dragHelper.processTouchEvent(event)
        return true
    }

    private inner class SettleRunnable internal constructor(private val mView: View) : Runnable {

        override fun run() {
            if (dragHelper != null && dragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(mView, this)
            } else {
                onDragFinished()
            }
        }
    }

    private fun onDragFinished() {
        // Any action you want to perform when dragging is finished
    }

    private fun moveToNextActivity(amount: Double) {
        val intent = Intent(this, ludo::class.java)
        intent.putExtra("AMOUNT_EXTRA", amount)
        startActivity(intent)
    }
}
