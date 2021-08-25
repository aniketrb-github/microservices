# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Spring Boot + GrapQL Integration Demo](https://javagyanmantra.wixsite.com/website/single-post/2018/02/13/GraphQLGraph-Query-Language)

### Spring Boot + GraphQL 
- GraphQL is an API query language, a server-side run time for executing queries by using a type system you define for your data.
- GraphQL was invented by Facebook in 2012 to support multiple technologies C# .NET, Clojure, Elixir, Erlang, Go, Groovy, Java, JavaScript, PHP, Python, Scala, Ruby etc.

Entry Point, Refer "PhotoController.java" for the actual GraphQL integration

- cURL for getting a data for a single photo based on its photoId - POST API to GET a PHOTO using GRAPHQL

curl --location --request POST 'http://localhost:8080/micron/getPhotoById' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getPhotoById(id: 1){
        id
        title
        url
    }
}'

curl --location --request POST 'http://localhost:8080/micron/getAllPhotos' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getAllPhotos{
        id
        albumId        
        url
		thumbnailUrl
    }
}'

- cURL for getting list of all photos - POST API to GET ALL PHOTOS using GRAPHQL

curl --location --request POST 'http://localhost:8080/micron/getAllPhotos' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getAllPhotos{
        id
        title
        url
    }
}'

curl --location --request POST 'http://localhost:8080/micron/getAllPhotos' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getAllPhotos{
        id
        albumId
        url
    }
}'

- cURL for getting list of al photos(REGULAR GET API)

curl --location --request GET 'http://localhost:8080/micron/photos'