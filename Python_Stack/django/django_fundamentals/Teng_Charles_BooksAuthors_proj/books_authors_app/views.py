from django.shortcuts import render, HttpResponse, redirect
from .models import Book, Author


def index(request):
    context = {
        "books_list": Book.objects.all(),
        "authors_list": Author.objects.all()
    }
    return render(request, "index.html", context)


def add_book(request):
    bTitle = request.POST["bTitle"]
    bDesc = request.POST["bDesc"]
    Book.objects.create(title=bTitle, desc=bDesc)
    return redirect("/")


def book_detail(request, b_id):
    context = {
        "book": Book.objects.get(id=b_id),
        "authors_list": Author.objects.all()
    }
    return render(request, "book_detail.html", context)


def book_add_author(request, b_id):
    author_id = Author.objects.get(id=request.POST["author_id"])
    book = Book.objects.get(id=b_id)
    book.authors.add(author_id)
    return redirect(f"/books/{b_id}")


def book_remove_author(request, b_id):
    author_id = Author.objects.get(id=request.POST["author_id"])
    book = Book.objects.get(id=b_id)
    book.authors.remove(author_id)
    return redirect(f"/books/{b_id}")


def authors(request):
    context = {
        "books_list": Book.objects.all(),
        "authors_list": Author.objects.all()
    }
    return render(request, "authors.html", context)


def add_author(request):
    fname = request.POST["fname"]
    lname = request.POST["lname"]
    notes = request.POST["notes"]
    Author.objects.create(first_name=fname, last_name=lname, notes=notes)
    return redirect("/authors")


def author_detail(request, a_id):
    context = {
        "author": Author.objects.get(id=a_id),
        "books_list": Book.objects.all()
    }
    return render(request, "author_detail.html", context)


def author_add_book(request, a_id):
    book_id = Book.objects.get(id=request.POST["book_id"])
    author = Author.objects.get(id=a_id)
    author.books.add(book_id)
    return redirect(f"/authors/{a_id}")


def author_remove_book(request, a_id):
    book_id = Book.objects.get(id=request.POST["book_id"])
    author = Author.objects.get(id=a_id)
    author.books.remove(book_id)
    return redirect(f"/authors/{a_id}")