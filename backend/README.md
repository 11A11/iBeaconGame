#First create a virtual Environment
__I am considering we are in /home folder__
```bash
pip install virtualenv
cd Documents
mkdir Heroku
cd Heroku
virtualenv env
source env/bin/activate   # Do this before starting to do anything
```


#Basic Heroku Setup with database
```bash
git clone https://github.com/zeerorg/basic-heroku.git
pip install -r requirements.txt
heroku login
heroku create
heroku addons:add heroku-postgresql:dev
git push heroku master
```

## After creating run python terminal
#####To run python terminal
```bash
heroku run python
```
#####Now input commands
```python
>>> from deploy import db
>>> db.create_all()
```
