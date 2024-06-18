from django.shortcuts import render, redirect
from django.contrib.auth import authenticate, login
from django.contrib.auth.models import User
from .forms import UserRegistrationForm, UserLoginForm
from django.http import JsonResponse
from .models import Ebook  # Import the Ebook model
from .models import listof_College
from django.http import HttpResponse
from .models import Question, Option
from django.core.exceptions import MultipleObjectsReturned


def aptitude_test(request):
    questions = Question.objects.all()
    return render(request, 'CARRIER/aptitude_test.html', {'questions': questions})


def aptitude_test_submit(request):
    if request.method == 'POST':
        total_marks = 0
        questions = Question.objects.all()

        for question in questions:
            selected_option_id = request.POST.get(f'question_{question.id}')
            try:
                correct_option = Option.objects.get(question=question, is_correct=True)
            except MultipleObjectsReturned:
                # Handle multiple correct options for a single question
                # Log the exception or display an error message
                pass
            except Option.DoesNotExist:
                # Handle case where no correct option is found
                pass

            if selected_option_id and int(selected_option_id) == correct_option.id:
                total_marks += 1

        suggested_stream = ""
        if total_marks <= 3:
            suggested_stream = "ARTS"
        elif total_marks <= 6:
            suggested_stream = "COMMERCE"
        else:
            suggested_stream = "SCIENCE"

        return render(request, 'CARRIER/aptitude_test_result.html',
                      {'total_marks': total_marks, 'suggested_stream': suggested_stream})
    else:
        return HttpResponse("Method Not Allowed")

def college_list(request):
    colleges = listof_College.objects.all()  # Retrieve all colleges from the database
    return render(request, 'CARRIER/college_list.html', {'colleges': colleges})

def ebook_list(request):
    ebooks = Ebook.objects.all()  # Query all ebook objects from the database
    return render(request, 'CARRIER/ebook_list.html', {'ebooks': ebooks})
def combined_page(request):
    return render(request, 'CARRIER/welcome_dashboard.html')

def register(request):
    if request.method == 'POST':
        form = UserRegistrationForm(request.POST)
        if form.is_valid():
            # Save username and email from the form
            username = form.cleaned_data['username']
            email = form.cleaned_data['email']

            # Create a new User object with the provided data
            user = User.objects.create_user(username=username, email=email)

            # Set the password for the user
            password = form.cleaned_data['password']
            user.set_password(password)

            # Save the user object with the hashed password
            user.save()

            # Redirect to the welcome dashboard page after successful registration
            return redirect('welcome_dashboard')
    else:
        form = UserRegistrationForm()
    return render(request, 'CARRIER/register.html', {'form': form})

def user_login(request):
    if request.method == 'POST':
        form = UserLoginForm(request.POST)
        if form.is_valid():
            username = form.cleaned_data['username']
            password = form.cleaned_data['password']
            user = authenticate(request, username=username, password=password)
            if user is not None:
                login(request, user)
                # Redirect to the welcome dashboard page after successful login
                return redirect('welcome_dashboard')
            else:
                # Handle invalid login
                pass
    else:
        form = UserLoginForm()
    return render(request, 'CARRIER/login.html', {'form': form})

def registration_success(request):
    # Redirect to the welcome dashboard page after successful registration
    return redirect('welcome_dashboard')
