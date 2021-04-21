from django.shortcuts import render, HttpResponse, redirect
from django.contrib import messages
from .models import User
from datetime import datetime, date
import bcrypt

def index(request):
    return render(request, "index.html")

#registration functions
def registration(request):
    errors = User.objects.reg_validator(request.POST)

    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect("/")

    else:
        reg_pw = request.POST["reg_pw"]
        hash_pw = bcrypt.hashpw(reg_pw.encode(), bcrypt.gensalt()).decode()

        user = User.objects.create(first_name=request.POST["fname"], last_name=request.POST["lname"], email=request.POST["reg_email"], password=hash_pw, birth_date=request.POST["bday"])

        request.session["uuid"] = user.id
        return redirect("/reg_success")

def reg_success(request):
    if "uuid" not in request.session:
        return redirect("/")

    context = {
        "user": User.objects.get(id = request.session["uuid"]),
    }
    return render(request, "success.html", context)
#registration functions end


#login functions
def login(request):
    errors = User.objects.log_validator(request.POST)
    
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect("/")

    else:
        user = User.objects.get(email=request.POST["log_email"])
        request.session["uuid"] = user.id
        return redirect("/log_success")

def log_success(request):
    if "uuid" not in request.session:
        return redirect("/")

    context = {
        "user": User.objects.get(id = request.session["uuid"]),
    }
    return render(request, "success.html", context)
#login functions end


#logout function
def logout(request):
    del request.session["uuid"]
    return redirect("/")