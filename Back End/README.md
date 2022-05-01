
## Part 1 - Read file into a database.

### How to use?
1. Run the cleanup_data.ipynb step by step to generate the precursor csv files.
2. Follow any necessary SQLlite commands required to generate the database (comments embedded in the python notebook).
3. In hindsight, I could have used sqllite3 Python library to automate the generation of the tables and databases but I wanted to make sure the data tables being imported were being done correctly. So, if I had a bit more time, I would have generated a script to automate the SQLlite portions. 


### Service to Pull/Read Content of File:

1. Given `codefoobackend_cfgames.csv` was inspected for any irregularities. There did not seem to be any clear things (e.g. empty cells that should not be empty or if they were empty, I am not sure how I would have filled in data). If I knew more context (e.g. franchise fields must always be filled) about the data, I would try to fill them in (e.g. insert creators and publishers for each media item).
3. `STORING`: I chose SQLlite because it is small, light-weight and easy to use. Plus the given dataset was small. If it was bigger, I may have used MySQL or something else more robust.
3. `SANITIZING`: I sanitized using pandas library from Python since it was easier to manipulate. Might investigate the data more closely given more time using some helpful hints here: https://support.microsoft.com/en-us/office/top-ten-ways-to-clean-your-data-2844b620-677c-47a7-ac3e-c2e157d1db19. But from my glance initially, there did not seem anything glaringly wrong with the dataset.
4. `NORMALIZATION`: I think the right theoretical way to build the data base is to split an entity or object into its own table (e.g. 1 table for each "thing"). I started normalizing the data to make it do that. But for practicality, I created some tables just for easy usage (e.g. movies table). This would avoid costly joins (if the dataset was much bigger).
5. `INDEXING`: Once the data was in SQLlite database, I tried to index on what I think the most common queries will be for API which are: `short_name` and `name`. Maybe apply some considerations from links like this in the future: https://dataschool.com/sql-optimization/how-indexing-works/ or https://medium.com/the-software-firehose/how-to-choose-a-table-index-for-your-sql-database-d47715a35f34 

----------------------------------------------------------------

## Part 2 - Build API Service that uses database

### How to Use?

1. Using Python 3 and pip, you can install the required packages from requirements.txt.
2. You can run the API server by calling: `python flask_api.py`. 
3. This will start the development server where you can then access the different API endpoints listed below:

```
/v1/media/<media_name>
/v1/reviews/<score>
/v1/media/summary_media_type
```

**Explanation**:
The three endpoints chosen were based on what seemed to be most popular endpoints people may want to access. (Obviously, you can build more and for more targeted use cases). I also learned it may be worth sketching out your API service first to give you an idea of views you may want to build in your data model in the database. 

There is a home page for a quick summary of the endpoints and data.

The first endpoint was built for quick and easy access/searching of a title the user may be interested. It was built in a way that partial matches would yield results (in case user doesn't remember or wants a less strict set of results). 

The second endpoint is a common use case amongst consumers like me which is to find media - whether it be movies, games or shows - that have a certain review score or higher. This could help filter out movies like Green Lantern or the Fantastic Four. 

The last endpoint is simply an aggregation metric endpoint that could be used to help summarize data as IGN continues to expand their directory and database of reviews of different types of media. 

Although much of the normalization was not used, I think further details about the requirements of our customers/API demands could help guide the discussion on what kind of views to build in the backend to minimize unncessary joins and excessive normalization.


