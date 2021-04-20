from django.db import models

# Create your models here.
class ShowManager(models.Manager):
    #validator for creating a show
    def new_validator(self, postData, shows_list):
        errors = {}
        if (len(postData["n_title"]) < 1):
            errors["n_title"] = "Title of the show must be entered"
        if (len(postData["n_network"]) < 1):
            errors["n_network"] = "The network the show airs on must be entered"
        if (len(postData["n_release"]) < 8):
            errors["n_release"] = "A valid date must be entered for the release date"
        if (len(postData["n_desc"]) > 0 and len(postData["n_desc"]) < 10):
            errors["n_desc"] = "Surely you can think of more to say about this show, right?"

        for show in shows_list:
            if (show.title == postData["n_title"]):
                errors["n_title"] = "The show already exists in the database"
        return errors
    
    
    #validator for editing a show
    def edit_validator(self, postData, shows_list):
        errors = {}
        if (len(postData["e_title"]) < 1):
            errors["e_title"] = "Title of the show must be entered"
        if (len(postData["e_network"]) < 1):
            errors["e_network"] = "The network the show airs on must be entered"
        if (len(postData["e_release"]) < 8):
            errors["e_release"] = "A valid date must be entered for the release date"
        if (len(postData["e_desc"]) > 0 and len(postData["e_desc"]) < 10):
            errors["e_desc"] = "Surely you can think of more to say about this show, right?"


class Show(models.Model):
    title = models.CharField(max_length=255)
    network = models.CharField(max_length=50)
    release = models.DateField(auto_now_add=False, auto_now=False)
    desc = models.TextField(null=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = ShowManager()