from django.urls import path
from . import views

urlpatterns = [
    path('', views.register, name='register'),  # Set registration page as root URL
    path('dashboard/', views.register, name='dashboard'),  # Placeholder for dashboard view
    path('login/', views.user_login, name='login'),
    path('register/', views.register, name='register'),
    path('ebook-list/', views.ebook_list, name='ebook_list'),
    path('aptitude-test/', views.aptitude_test, name='aptitude_test'),
    path('aptitude-test-submit/', views.aptitude_test_submit, name='aptitude_test_submit'),
    path('colleges/', views.college_list, name='college_list'),
    path('welcome-dashboard/', views.combined_page, name='welcome_dashboard'),  # Define URL pattern for welcome dashboard
    path('registration-success/', views.registration_success, name='registration_success'),  # Define URL pattern for registration success
]
