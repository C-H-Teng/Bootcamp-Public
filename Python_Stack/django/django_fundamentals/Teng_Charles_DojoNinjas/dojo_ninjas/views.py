from django.shortcuts import render, HttpResponse, redirect
from .models import Dojos, Ninjas

def index(request):
    context = {
        "dojos_list": Dojos.objects.all(),
        "ninjas_list": Ninjas.objects.all()
    }
    return render(request, "index.html", context)


def add_dojo(request):
    Dojos.objects.create(
        name=request.POST["d_name"],
        city=request.POST["d_city"],
        state=request.POST["d_state"],
    )
    return redirect("/")


def add_ninja(request):
    Ninjas.objects.create(
        dojo_id = Dojos.objects.get(id=request.POST["dojoID"]),
        first_name=request.POST["fname"],
        last_name=request.POST["lname"],
    )
    return redirect("/")

def delete(request):
    dojo = Dojos.objects.get(id=request.POST["del_dojo"])
    dojo.delete()
    return redirect("/")