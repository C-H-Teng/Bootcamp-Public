from django.shortcuts import render, HttpResponse, redirect
from .models import Ninjas, Dojos

def index(request):
    return HttpResponse("this is the equivalent of @app.route('/')!")