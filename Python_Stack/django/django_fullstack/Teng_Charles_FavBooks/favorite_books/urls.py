from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path("register", views.register),
    path("login", views.login),
    path("main", views.main),
    path("main/add_fav/<int:b_id>", views.add_fav),

    path("add_book", views.add_book),
    path("book/<int:b_id>", views.book_detail),
    path("book/<int:b_id>/addfav", views.det_add_fav),
    path("book/<int:b_id>/unfav", views.remove_fav),
    path("book/<int:b_id>/edit", views.book_edit),
    path("book/<int:b_id>/delete", views.book_delete),

    path("logout", views.logout),
]