from django.shortcuts import render, HttpResponse, redirect
from .models import Books, Authors, Books_Authors

def index(request):
    return render(request, "index.html")