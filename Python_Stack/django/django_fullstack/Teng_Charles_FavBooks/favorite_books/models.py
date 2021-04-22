from django.db import models
import re, bcrypt

# Create your models here.
class UserManager(models.Manager):
    #registration validation start
    def reg_validator(self, postData):
        errors = {}
        if len(postData["fname"]) < 1:
            errors["fname"] = "First name must be entered."
        if len(postData["lname"]) < 1:
            errors["lname"] = "Last name must be entered."

        #email validation
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['reg_email']):
            errors["reg_email"] = "Invalid email address!"
        else:
            user_list = User.objects.filter(email=postData["reg_email"])
            if (len(user_list) > 0):
                errors["reg_email"] = "User with that email already exists."

        #password validation
        if len(postData["reg_pw"]) < 8:
            errors["reg_pw"] = "Password must be at least 8 characters long."
        if postData["reg_pw"] != postData["confirm_pw"]:
            errors["confirm_pw"] = "Password and password confirmation must match."
        return errors
        #registration function end
    
    #login validation function start
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
    #login validation function end

    #book validation function start
    def book_validator(self, postData):
        errors = {}
        if len(postData["b_title"]) < 1:
            errors["b_title"] = "Title of the book is required."
        if len(postData["b_desc"]) < 5:
            errors["b_desc"] = "I'm sure you can enter a better description."
        return errors


class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    #books_uploaded = foreign key from Book class
    #books_liked = many to many field from Book class
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()

class Book(models.Model):
    title = models.CharField(max_length=255)
    desc = models.TextField()
    uploaded_by = models.ForeignKey(User, related_name="books_uploaded", on_delete=models.CASCADE)
    liked_by = models.ManyToManyField(User, related_name="books_liked")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
