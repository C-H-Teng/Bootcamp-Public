from django.shortcuts import render, HttpResponse, redirect
from django.http import JsonResponse

def index(request):
    return HttpResponse('test123')

def redirect_blogs(request):
    return redirect('/blogs')

def show(request, num):
    return HttpResponse(f'placeholder to display blog number: {num}')

def edit(request, num):
    return HttpResponse(f'placeholder to edit blog number: {num}')

def root(request):
    return HttpResponse('placeholder to later display a list of all blogs with a method named "index"')

def new(request):
    return HttpResponse('placeholder to display a new form to create a new blog')

def create(request):
    return redirect('/')

def destroy(request, num):
    return redirect('/blogs')

def redir_json(request):
    return JsonResponse({"response": "JSON response from redirected_method", "status": True})