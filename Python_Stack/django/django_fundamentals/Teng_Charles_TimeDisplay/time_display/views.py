from django.shortcuts import render, HttpResponse, redirect
from time import gmtime, strftime
import datetime

def index(request):
    context = {
        "Time": strftime("%Y-%m-%d %H:%M %p", gmtime())
    }
    return render(request, 'index.html', context)