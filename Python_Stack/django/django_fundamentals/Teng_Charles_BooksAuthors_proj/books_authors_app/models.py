from django.db import models

# Create your models here.
class Book(models.Model):
    title = models.CharField(max_length=255)
    desc = models.TextField(null=True)
    #authors = list of authors that contributed to the book
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


class Author(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    notes = models.TextField(null=True)
    books = models.ManyToManyField(Book, related_name="authors")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)