# movie-catalog-app
The motive of this application is to display how micro-services collaborate and communicate with each other via REST API's
Here, I have used the Spring Boot, Spring Cloud and Netflix - Eureka initially, excluding the JPA/DB connections so as to focus of the micro-services mainly.

**This Micro-service application contains 3 micro-services & 1 discovery-server**
a) movie-catalog-app as 'movie-catalog-service'
b) movie-info-app as 'movie-info-service'
c) ratings-data-app as 'ratings-data-service'
d) discovery-server as 'eureka-service'

**Micro-service Application Overview**
- The ratings-data-service accepts userId as input & returns the ratings-list of all the movies watched by that user as its response.
- The movie-info-service accepts a movieId and returns a movie entity in return.
- Therefore, the movie-catalog-service consumes the ratings-data-service which provides it list of movies with movieId's
Upon these movieId's the iteration takes place to fetch the movie detail info for each movie.
- The movie-catalog-service then consolidates the data into a list & finally sends it as a response
- movie-catalog-service acts as parent service which consumes 2 other services & collects & consolidates data & sends a final result

How to run the micro-services application
You can use any latest STS/Eclipse IDE available.
Pull these Projects on your machine via GitBash/GitHub desktop or just download the ZIP file & extract the content & set that up in the IDE
After all set up is done, follow the following steps:

1) Start the discover-server which runs on port: 8761 with the name: 'eureka-service'
- Once it starts successfully, paste this URL in your browser http://localhost:8761 & observe the dashboard page that displays with all the metadata info.

2) Then, start the 'movie-info-service' which shall run on the port: 18082 
- Once this successfully starts observe the console of this service as well as the discovery-server
- It shows that service is registering itself to a server & the server says the same
- No go refresh your browser page & see that you movie-info-service will appear there with status: UP

3) Start the 'ratings-data-service' which will run on the port: 18083
- Once this successfully starts observe the console of this service as well as the discovery-server
- Refresh the browser

3) Later start the 'movie-catalog-service' which will run on the port: 18081
- Once this successfully starts observe the console of this service as well as the discovery-server
- Refresh the browser & now you are done with the deployment of all your micro-services

Click on the movie-catalog-service URL & edit the URL properly to http://localhost:18081/catalog/1
This invokes the movie-info-service & ratings-data-service to give you a consolidated data
{
	"movieCatalogItems": [{
		"name": "Dummy HardCodeData Movie",
		"description": "A movie of great posum !",
		"rating": 4
	},{
		"name": "Dummy HardCodeData Movie",
		"description": "A movie of great posum !",
		"rating": 5
	}]
}

MovieInfoService Application: http://localhost:18082/movies/AvengersEndgame-2019
Movie Object returned for a movieId: AvengersEndgame-2019 (consider, this movie has movieId=1)
{
	"id": "info",
	"name": "Dummy HardCodeData Movie",
	"description": "A movie of great posum !"
}

RatingsDataService Application: http://localhost:18083/ratingsdata/1
This returns the movie-rating data for a movieId: 1 as follows
{
	"movieId": "1",
	"rating": 4
}

