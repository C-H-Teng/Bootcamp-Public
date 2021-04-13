from django.urls import path     
from . import views

urlpatterns = [
    path('', views.index),
    path('guess_result', views.guess_result),
    path('restart', views.restart),
    path('ldbrd_redirect', views.ldbrd_redirect),
    path('leaderboard', views.leaderboard),
    path('ldbrd_reset', views.ldbrd_reset),
]