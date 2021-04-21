from django.urls import path
from . import views

urlpatterns = [
    path("", views.index),
    path("registration", views.registration),
    path("reg_success", views.reg_success),
    path("login", views.login),
    path("log_success", views.log_success),
    path("logout", views.logout),
]