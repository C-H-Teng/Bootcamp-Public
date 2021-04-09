from django.urls import path     
from . import views
urlpatterns = [
    path('blogs/json', views.redir_json),
    path('', views.redirect_blogs),
    path('blogs', views.root),
    path('blogs/<num>', views.show),
    path('blogs/<num>/edit', views.edit),
    path('blogs/new', views.new),
    path('create', views.create),
    path('blogs/<num>/delete', views.destroy),
]