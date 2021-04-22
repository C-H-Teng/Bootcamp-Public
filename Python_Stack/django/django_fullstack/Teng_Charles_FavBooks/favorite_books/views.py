from django.shortcuts import render, HttpResponse, redirect
from django.contrib import messages
from .models import User, Book
import bcrypt

def index(request):
    return render(request, "index.html")

#registration functions
def register(request):
    errors = User.objects.reg_validator(request.POST)

    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect("/")

    else:
        reg_pw = request.POST["reg_pw"]
        hash_pw = bcrypt.hashpw(reg_pw.encode(), bcrypt.gensalt()).decode()

        user = User.objects.create(first_name=request.POST["fname"], last_name=request.POST["lname"], email=request.POST["reg_email"], password=hash_pw)

        request.session["uuid"] = user.id
        return redirect("/main")

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
        return redirect("/main")
#login functions end


#main page after log in/register
def main(request):
    if "uuid" not in request.session:
        return redirect("/")

    context = {
        "user": User.objects.get(id = request.session["uuid"]),
        "all_users": User.objects.all(),
        "book_list": Book.objects.all()
    }
    return render(request, "main.html", context)



#add book function
def add_book(request):
    errors = User.objects.book_validator(request.POST)
    
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect("/main")

    else:
        logged_user = User.objects.get(id=request.session["uuid"])
        btitle = request.POST["b_title"]
        bdesc = request.POST["b_desc"]
        new_book = Book.objects.create(
            title=btitle,
            desc=bdesc,
            uploaded_by=logged_user,
            # liked_by = logged_user, many to many can not be assigned at creation
        )
        new_book.liked_by.add(logged_user)
        return redirect("/main")


#book details page
def book_detail(request, b_id):
    context = {
        "user": User.objects.get(id=request.session["uuid"]),
        "book": Book.objects.get(id=b_id),
    }
    return render(request, "book_detail.html", context)

def book_edit(request, b_id):
    errors = User.objects.book_validator(request.POST)
    
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect(f"/book/{b_id}")

    else:
        book = Book.objects.get(id=b_id)
        book.title = request.POST["b_title"]
        book.desc = request.POST["b_desc"]
        book.save()
        return redirect(f"/book/{b_id}")

def book_delete(request, b_id):
    book = Book.objects.get(id=b_id)
    book.delete()
    return redirect("/main")


#favorites functions
def add_fav(request, b_id): #from /main
    book = Book.objects.get(id=b_id)
    logged_user = User.objects.get(id=request.session["uuid"])

    book.liked_by.add(logged_user)
    return redirect("/main")

def det_add_fav(request, b_id): #from /book/b_id
    book = Book.objects.get(id=b_id)
    logged_user = User.objects.get(id=request.session["uuid"])

    book.liked_by.add(logged_user)
    return redirect(f"/book/{b_id}")

    book.liked_by.add(logged_user)
    return redirect(f"/book/{b_id}")

def remove_fav(request, b_id):
    book = Book.objects.get(id=b_id)
    logged_user = User.objects.get(id=request.session["uuid"])

    book.liked_by.remove(logged_user)
    return redirect(f"/book/{b_id}")


#logout function
def logout(request):
    del request.session["uuid"]
    return redirect("/")