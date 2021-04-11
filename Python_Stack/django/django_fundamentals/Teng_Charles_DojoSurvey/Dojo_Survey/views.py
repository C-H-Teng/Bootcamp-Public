from django.shortcuts import render, HttpResponse, redirect

def index(request):
    return render(request,"index.html")

def result(request):
    print("Got post info")
    name_from_form = request.POST["name"]
    email_from_form = request.POST["email"]
    gender_from_form = request.POST["gender"]
    langLrnd_from_form = request.POST.getlist("langLrnd")
    langData = ""
    y = 0
    for x in langLrnd_from_form:
        langData += x
        if(y != len(x)-1):
            langData += ", "
            y += 1
    context = {
        "name_on_template" : name_from_form,
        "email_on_template" : email_from_form,
        "gender_on_template" : gender_from_form,
        "langLrnd_on_template" : langData
    }

    return render(request, "result.html", context)