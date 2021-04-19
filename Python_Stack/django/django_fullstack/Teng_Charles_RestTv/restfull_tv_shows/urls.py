from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('shows', views.shows),
    path('shows/new', views.new_show),
    path('shows/new/new_show_create', views.new_show_create),
    path('shows/<int:show_id>/details', views.show_details),
    path('shows/<int:show_id>/edit', views.show_edit),
    path('shows/<int:show_id>/update', views.show_update),
    path('shows/<int:show_id>/delete', views.delete)
]