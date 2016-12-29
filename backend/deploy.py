from flask import Flask
import os

app = Flask(__name__)

from urls import *

if __name__ == '__main__':
    app.run(debug=True)
