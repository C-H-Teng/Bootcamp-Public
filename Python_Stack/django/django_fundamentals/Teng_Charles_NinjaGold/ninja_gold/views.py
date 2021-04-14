from django.shortcuts import render, HttpResponse, redirect
import random

def index(request):
    if "gold_count" in request.session:
        print("Session's gold count =", request.session["gold_count"])
    else:
        request.session["gold_count"] = 0
        request.session["activity"] = []
    return render(request, "index.html")

def process_money(request):
    #farm gold
    if (request.POST["make_gold"] == "farm"):
        farm_gold = random.randint(10,20)
        request.session["gold_count"] += farm_gold
        request.session["activity"].append("You earned "+str(farm_gold)+" gold from the farm!")
    #farm gold end

    #cave gold
    elif (request.POST["make_gold"] == "cave"):
        cave_gold = random.randint(5,10)
        request.session["gold_count"] += cave_gold
        request.session["activity"].append("You found "+str(cave_gold)+" gold in the cave!")
    #cave gold end

    #house gold
    elif (request.POST["make_gold"] == "house"):
        house_gold = random.randint(2,5)
        request.session["gold_count"] += house_gold
        request.session["activity"].append("You stole "+str(house_gold)+" gold from the house!")
    #house gold end

    #casino gold
    elif (request.POST["make_gold"] == "casino"):
        casino_gold = random.randint(-50,50)
        request.session["gold_count"] += casino_gold
        if (casino_gold < 0):
            request.session["activity"].append("You lost "+str(casino_gold)+" gold from the casino!")
        elif (casino_gold > 0):
            request.session["activity"].append("You made "+str(casino_gold)+" gold from the casino!")
        elif (casino_gold == 0):
            request.session["activity"].append("You broke even at the casino!")
    #casino gold end

    return redirect("/")

def reset(request):
    del request.session["gold_count"]
    del request.session["activity"]
    return redirect("/")