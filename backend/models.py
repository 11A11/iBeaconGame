import mongoengine as Engine
import os

Engine.connect('scripy', host=os.environ['DATABASE_URL']+"scripy")

class Comment(Engine.EmbeddedDocument):
    data = Engine.StringField(required=True)
    author = Engine.StringField(required=True)

class Script(Engine.Document):
    title = Engine.StringField(required=True, max_length=25, min_length=5)
    author = Engine.StringField(required=True)
    description = Engine.StringField()
    link = Engine.URLField(unique=True, required=True)
    stars = Engine.IntField(default=0)
    comments = Engine.EmbeddedDocumentListField(Comment)
    upvoted_by = Engine.ListField(Engine.ObjectIdField())
    date_time = Engine.DateTimeField(required=True)
    meta = {'collection': 'scripts'}

class User(Engine.Document):
    username = Engine.StringField(required=True, unique=True, max_length=25, min_length=5, regex='^[A-Za-z0-9_-]{5,25}$')
    first_name = Engine.StringField(required=True)
    last_name = Engine.StringField(required=True)
    password = Engine.StringField(required=True)
    email = Engine.EmailField(unique=True, required=False, sparse=True)
    stars = Engine.IntField(default=0)
    starred_users = Engine.ListField(Engine.ObjectIdField())
    starred_scripts = Engine.ListField(Engine.ReferenceField('Script', reverse_delete_rule=Engine.PULL))
    scripts = Engine.ListField(Engine.ReferenceField(Script))
    github = Engine.URLField(unique=True)
    meta = {'collection': 'users'}