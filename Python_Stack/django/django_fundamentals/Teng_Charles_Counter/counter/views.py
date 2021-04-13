from django.shortcuts import render, HttpResponse, redirect

def index(request):
    if 'adjusted_count' in request.session:
        request.session["adjusted_count"] += 1
    else:
        request.session["adjusted_count"] = 1

    if 'total_count' in request.session:
        print('key exists!')
        request.session["total_count"] += 1
    else:
        print("key 'count' does NOT exist")
        request.session["total_count"] = 1
    return render(request, "index.html")

def add_two(request):
    request.session["adjusted_count"] += 1
    return redirect("/")

def custom_add(request):
    num_from_form = int(request.POST["custom_num"])
    request.session["adjusted_count"] = int(request.session["adjusted_count"]) + (num_from_form - 1)
    return redirect("/")

def destroy_session(request):
    del request.session["adjusted_count"]
    return redirect("/")