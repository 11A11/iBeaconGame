import datetime
import json
from flask import Response, request, session

from deploy import app
from models import *

def json_return(js, **kwargs):
    return Response(json.dumps(js), mimetype='application/json', **kwargs)

@app.route('/api/script', methods=['GET', 'POST'])
def all_scripts():
    if request.method == 'POST':
        if 'user' in session:
            if request.is_json:
                written = request.get_json()
            else:
                written = request.form

            written.update({"stars":0, "upvoted_by":[], "date_time": datetime.datetime.utcnow(), "author":session['user']})
            script = Script(**written)
            script.save()
            return json_return(script.to_json())
        else:
            return json_return({'message': 'Not Signed In'}, status=400)


    elif request.method == 'GET':
        scripts = Script.objects.to_json()
        return json_return(scripts)

@app.route('/api/script/<id>')
def get_script(id):
    try:
        return json_return(Script.objects.get(id=id).to_json())
    except Exception as e:
        return json_return({'message': str(e)}, status=404)

@app.route('/api/script/<string:id>/upvote', methods=['PUT'])
def upvote_script(id):
    script = Script.objects.get(id=id)
    user = User.objects.get(username=session["user"])
    if user.id not in script.upvoted_by:
        script.stars += 1
        script.upvoted_by.append(user.id)
        user.starred_scripts.append(script)
        script.save()
        user.save()
    else:
        script.stars -= 1
        script.upvoted_by.remove(user.id)
        user.starred_scripts.remove(script)
        script.save()
        user.save()
    return json_return(script.to_json())

@app.route('/api/login', methods=['POST'])
def api_login(username=None, password=None):
    if username == None:
        username = request.form["username"]
        password = request.form["password"]

    user = User.objects(**{"username": username})[0]
    print(user.password)
    if pbkdf2_sha256.verify(password, user["password"]):
        session['user'] = user["username"]
        return json_return({'message': 'logged in'})
    
    return json_return({'message': 'wrong request'}, status=400)

@app.route('/api/logout')
def api_logout():
    # remove the username from the session if it's there
    user = session.pop('user', None)
    if user is not None:
        return json_return({'user': user,'message': 'logged out'})
    else:
        return json_return({'message': 'Not Signed In'}, status=400)

@app.route('/api/script/<string:id>/comment', methods=['POST'])
def add_comment(id):
    if 'user' in session:
        written = request.get_json()
        comment = Comment(author=session["user"], data=written["data"])
        script = Script.objects.get(id=id)
        script.comments.append(comment)
        script.save()
        return json_return(script.to_json())