from django.shortcuts import render, HttpResponse, redirect
from .models import Show
# from time import gmtime, strftime
from datetime import datetime, date

def index(request):
    return redirect("/shows")

def shows(request):
    context = {
        "shows_list": Show.objects.all()
    }
    return render(request, "index.html", context)

def new_show(request):
    return render(request, "new_show.html")

def new_show_create(request):
    Show.objects.create(title=request.POST["n_title"], network=request.POST["n_network"], release=request.POST["n_release"], desc=request.POST["n_desc"])
    show_id = Show.objects.last().id
    return redirect(f"/shows/{show_id}/details")

def show_details(request, show_id):
    context = {
        "show": Show.objects.get(id=show_id),
    }
    return render(request, "show_details.html", context)

def show_edit(request, show_id):
    date = Show.objects.get(id=show_id).release
    context = {
        "show": Show.objects.get(id=show_id),
        "date": date.strftime("%Y-%m-%d")
    }
    return render(request, "show_edit.html", context)

def show_update(request, show_id):
    show = Show.objects.get(id=show_id)
    show.title = request.POST["e_title"]
    show.network = request.POST["e_network"]
    show.release = request.POST["e_release"]
    show.desc = request.POST["e_desc"]
    show.save()
    return redirect(f"/shows/{show_id}/details")

def delete(request, show_id):
    Show.objects.get(id=show_id).delete()
    return redirect("/shows")