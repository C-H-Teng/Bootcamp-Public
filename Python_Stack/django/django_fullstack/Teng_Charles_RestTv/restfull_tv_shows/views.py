from django.shortcuts import render, HttpResponse, redirect
from django.contrib import messages
from .models import Show, ShowManager
from datetime import datetime, date

def index(request):
    return redirect("/shows")

def shows(request):
    context = {
        "shows_list": Show.objects.all()
    }
    return render(request, "index.html", context)

def new_show(request):
    current_date = datetime.now()
    context = {
        "present": current_date.strftime("%Y-%m-%d")
    }
    return render(request, "new_show.html", context)

def new_show_create(request):
    errors = Show.objects.new_validator(request.POST, Show.objects.all())

    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect("/shows/new")
    
    else:
        new_show = Show.objects.create(title=request.POST["n_title"], network=request.POST["n_network"], release=request.POST["n_release"], desc=request.POST["n_desc"])
    
    return redirect(f"/shows/{new_show.id}/details")

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
    errors = Show.objects.edit_validator(request.POST, Show.objects.all())

    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect(f"/shows/{show_id}/edit")
    
    else:
        show.title = request.POST["e_title"]
        show.network = request.POST["e_network"]
        show.release = request.POST["e_release"]
        show.desc = request.POST["e_desc"]
        show.save()
    return redirect(f"/shows/{show_id}/details")

def delete(request, show_id):
    Show.objects.get(id=show_id).delete()
    return redirect("/shows")