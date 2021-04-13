from django.shortcuts import render, HttpResponse, redirect
import random

def index(request):
    if 'rando_num' in request.session:
        print("Session's random number =", request.session["rando_num"])
    else:
        request.session["rando_num"] = random.randint(1,100)
        request.session["attempts_left"] = 5
        request.session["attempts_toWin"] = 0
        print("Session's random number =", request.session["rando_num"])
    return render(request, "index.html")


def restart(request):
    del request.session["rando_num"]
    del request.session["guess_reply"]
    del request.session["game_state"]
    del request.session["attempts_left"]
    del request.session["attempts_toWin"]
    return redirect("/")


def guess_result(request):
    if(int(request.POST["num_guess"]) < int(request.session["rando_num"])):
        request.session["guess_reply"] = "Too low!"
        request.session["game_state"] = "Lose"
        request.session["attempts_left"] = int(request.session["attempts_left"]) - 1
        request.session["attempts_toWin"] = int(request.session["attempts_toWin"]) +1

    if(int(request.POST["num_guess"]) > int(request.session["rando_num"])):
        request.session["guess_reply"] = "Too high!"
        request.session["game_state"] = "Lose"
        request.session["attempts_left"] = request.session["attempts_left"] - 1
        request.session["attempts_toWin"] = int(request.session["attempts_toWin"]) +1

    if(int(request.POST["num_guess"]) == int(request.session["rando_num"])):
        request.session["guess_reply"] = request.POST["num_guess"] + " was the number!"
        request.session["attempts_toWin"] = int(request.session["attempts_toWin"]) +1
        request.session["game_state"] = "Win"

    print("Guess reply: " + request.session["guess_reply"])
    print("Game state: " + request.session["game_state"])
    print("Attempts left:", request.session["attempts_left"])

    return redirect("/")

def leaderboard(request):
    return render(request, "leaderboard.html")

def ldbrd_redirect(request):
    name_from_form = request.POST["lead_name"]
    if 'game_history' not in request.session:
        request.session["game_history"] = []
    context = {
        "name_on_template" : name_from_form,
        "attempts_to_win" : request.session["attempts_toWin"]
    }
    request.session["game_history"].append(context)
    request.session.save()
    return redirect("/leaderboard")

def ldbrd_reset(request):
    del request.session["game_history"]
    return redirect("/restart")