from django.db import models
from datetime import datetime, date
import re, bcrypt

# Create your models here.
class UserManager(models.Manager):
    def reg_validator(self, postData):
        errors = {}
        if len(postData["fname"]) < 1:
            errors["fname"] = "First name must be entered."
        if len(postData["lname"]) < 1:
            errors["lname"] = "Last name must be entered."
            
        #birthday validation
        if len(postData["bday"]) < 1:
            errors["bday"] = "Please enter date of birth."
        else:
            form_bday = datetime.strptime(postData["bday"], "%Y-%m-%d")
            if datetime.now() < form_bday:
                errors["bday"] = "You can not be born in the future."
            elif datetime.today().year - form_bday.year < 13:
                errors["bday"] = "Must be age 13 or older to register."

        #email validation
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['reg_email']):
            errors["reg_email"] = "Invalid email address!"
        else:
            user_list = User.objects.filter(email=postData["email"])
            if (len(user_list) > 0):
                errors["reg_email"] = "User with that email already exists."

        #password validation
        if len(postData["reg_pw"]) < 8:
            errors["reg_pw"] = "Password must be at least 8 characters long."
        if postData["reg_pw"] != postData["confirm_pw"]:
            errors["confirm_pw"] = "Password and password confirmation must match."
        return errors
        #registration function end
    
    def log_validator(self, postData):
        errors = {}

        user_list = User.objects.filter(email=postData["log_email"])
        if len(user_list) > 0:
            user = user_list[0]
            if not bcrypt.checkpw(postData["log_pw"].encode(), user.password.encode()):
                errors["log_pw"] = "Invalid credentials."
        else:
            errors["log_email"] = "Invalid credentials."
        return errors


class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    birth_date = models.DateField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()