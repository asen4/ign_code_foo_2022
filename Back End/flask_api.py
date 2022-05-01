from flask import Flask, jsonify
import json
import sqlite3
from sqlite3 import Error


# Initially used data to test
# data = pd.read_csv('codefoobackend_cfgames.csv')

# Establish database connection:
conn = None
try:
    conn = sqlite3.connect('code_foo.db', check_same_thread=False)
except Error as e:
    print(e)


'''
Build an API service that utilizes your database. Include at least 3 endpoints 
that allow for clients to request data based on how you decided to store it. 

In addition, incorporate data/response filtering and/or sorting based on additional 
parameters supplied by the client utilizing your endpoint(s). 
Explain your decisions and methods of implementation.
'''

app = Flask(__name__)
app.config["DEBUG"] = True

@app.route('/', methods=['GET'])
def home():
    responses="""
    <div style='text-align:center;'> 
    <h1> Part 1: Store File in a SQL Database </h1>
    <p> How was storing performed? In a SQLlite database </p>
    <p> How was sanitizing performed? Python pandas dataframe </p>
    <p> How was normalizing performed? Roughly based on what each item represented (e.g. reviews, media, and views for each category of media) </p>
    <p> How was indexing performed? Based on common join keys or common columns used for querying for API</p>
    </div>
    
    <div style='text-align:center;'> 
    <h1> Part 2: Build an API </h1>
    <p> GET API 1 -> Looks up a media name from the database (partial string matching works)</p>
    <p> GET API 2 -> Looks up media reviews for only "good" reviews (whatever the score rating the user puts in)  </p>
    <p> GET API 3 -> Does basic summary aggregation of inventory of reviews IGN has so far  </p>
    
    </div>
    """
    return responses


@app.route('/v1/media/<media_name>', methods=['GET'])
def get_specific_media(media_name):
    """The user enters a name of the media they are interested in and this endpoint queries the database for it"""
    cur = conn.cursor()
    cur.execute(f"""SELECT * FROM media WHERE name LIKE '%{media_name}%';""")
    
    results = cur.fetchall()
    r = [dict((cur.description[i][0], value) for i, value in enumerate(row)) for row in results]

    return json.dumps(r)

@app.route('/v1/reviews/<score>', methods=['GET'])
def get_good_media(score):
    """The user enters a score between 0 and 10 and gets all
    media having review_scores above or equal to that score sorted from
    highest rating to lowest rating."""

    if (float(score) < 0 or float(score) >= 10):
        return (jsonify({"error": "Invalid Score submitted - must be between 0 and 10 [0, 10)",}), 403)
    
    cur = conn.cursor()
    cur.execute(f"""SELECT * FROM reviews WHERE review_score >= {score} ORDER BY review_score DESC;""")
    
    results = cur.fetchall()
    r = [dict((cur.description[i][0], value) for i, value in enumerate(row)) for row in results]

    return json.dumps(r)

@app.route('/v1/media/summary_media_type', methods=['GET'])
def summary():
    """Count the different types of media by category in the given dataset"""
    
    cur = conn.cursor()
    cur.execute(f"""SELECT media_type, COUNT(*) AS ct FROM media_metadata GROUP BY media_type;""")
    
    results = cur.fetchall()
    r = [dict((cur.description[i][0], value) for i, value in enumerate(row)) for row in results]

    return json.dumps(r)

app.run()
