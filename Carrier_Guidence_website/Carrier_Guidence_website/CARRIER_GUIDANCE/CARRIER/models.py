from django.db import models
from django.contrib.auth.models import User

class Question(models.Model):
    question_text = models.CharField(max_length=255)

class Option(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    option_text = models.CharField(max_length=255)
    is_correct = models.BooleanField(default=False)
class Ebook(models.Model):
    title = models.CharField(max_length=100)
    file = models.FileField(upload_to='media/ebooks/')

    def __str__(self):
        return self.title
class UserProfile(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    # Add additional fields as needed (e.g., user_id)
class listof_College(models.Model):
  name = models.CharField(max_length=100)
  std = models.CharField(max_length=10)
  cutoff = models.CharField(max_length=100)
  location = models.CharField(max_length=100)