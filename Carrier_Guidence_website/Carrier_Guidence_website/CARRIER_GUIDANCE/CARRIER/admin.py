from django.contrib import admin
from .models import Ebook
from .models import listof_College
from .models import Question, Option

admin.site.register(Question)
admin.site.register(Option)
admin.site.register(listof_College)

admin.site.register(Ebook)
# Register your models here.
