from django.shortcuts import render, HttpResponse, redirect
from .models import Users

def index(request):
    context = {
        "users_list": Users.objects.all()
    }
    return render(request, "index.html", context)

def add_user(request):
    Users.objects.create(
        first_name=request.POST["fname"],
        last_name=request.POST["lname"],
        email_address=request.POST["email"],
        age=request.POST["age"]
    )
    return redirect("/")