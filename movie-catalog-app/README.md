# movie-catalog-app
It contains 3 micro-services projects, namely movie-catalog-service, movie-info-service & ratings-data-service.
The movie-catalog-service consumes the ratings-data-service as well as movie-info-service.
The movie-catalog-service obtains data from above 2 micro-services, forms a consolidated list of that data.
And then send this consolidated list as the end-result to the consumer.
Hence, here the movie-catalog-service acts like a parent service per say.
