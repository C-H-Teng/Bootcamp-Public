from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('add_book', views.add_book),
    path('books/<int:b_id>', views.book_detail),
    path('books/<int:b_id>/add_author', views.book_add_author),
    path('books/<int:b_id>/remove_author', views.book_remove_author),

    path('authors', views.authors),
    path('add_author', views.add_author),
    path('authors/<int:a_id>', views.author_detail),
    path('authors/<int:a_id>/add_book', views.author_add_book),
    path('authors/<int:a_id>/remove_book', views.author_remove_book),
]