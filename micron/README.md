# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Spring Boot + GraphQL Integration Demo](https://javagyanmantra.wixsite.com/website/single-post/2018/02/13/GraphQLGraph-Query-Language)

### Spring Boot + GraphQL 
- GraphQL is an API query language, a server-side run time for executing queries by using a type system you define for your data.
- GraphQL was invented by Facebook in 2012 to support multiple technologies C# .NET, Clojure, Elixir, Erlang, Go, Groovy, Java, JavaScript, PHP, Python, Scala, Ruby etc.

Entry Point, Refer "PhotoController.java" for the actual GraphQL integration

A) cURL commands for Album Resource with GraphQL Support

A1) GET API to get an album by albumId
curl --location --request POST 'http://localhost:8080/micron/getAlbumById' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getAlbumById(id: 4) {
        id
        userId
        title
    }
}'

A2) GET API to get a list of albums for a particular userId
curl --location --request POST 'http://localhost:8080/micron/getAlbumsByUserId' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getAlbumsByUserId(userId: 2) {
        userId
        title
    }
}'

A3) GET API to get entire list of albums
curl --location --request POST 'http://localhost:8080/micron/getAllAlbums' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getAllAlbums {
        userId
        title
    }
}'

A4)
curl --location --request GET 'http://localhost:8080/micron/albums'
curl --location --request GET 'http://localhost:8080/micron/albums/44'
curl --location --request GET 'http://localhost:8080/micron/users/5/albums'

B)

B1) 
curl --location --request POST 'http://localhost:8080/micron/getAllComments' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getAllComments {
        postId
        name
        email
        body
    }
}'

B2)
curl --location --request POST 'http://localhost:8080/micron/getCommentsByPostId' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getCommentsByPostId(postId: 20) {
        postId
        name        
        body
    }
}'

B3)
curl --location --request POST 'http://localhost:8080/micron/getCommentById' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getCommentById(id: 10) {
        id
        postId
        name        
        email
    }
}'

B4)
curl --location --request GET 'http://localhost:8080/micron/comments'
curl --location --request GET 'http://localhost:8080/micron/comments/123'
curl --location --request GET 'http://localhost:8080/micron/posts/33/comments'

C)

C1) 
curl --location --request POST 'http://localhost:8080/micron/getPhotoById' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getPhotoById(id: 10) {
        id
        title        
        url        
        thumbnailUrl
    }
}'

C2)
curl --location --request POST 'http://localhost:8080/micron/getPhotosByAlbumId' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getPhotosByAlbumId(albumId: 2) {
        id
        albumId
        title        
        url                
    }
}'

C3)
curl --location --request POST 'http://localhost:8080/micron/getAllPhotos' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getAllPhotos {
        title        
        url                
    }
}'

C4) 
curl --location --request GET 'http://localhost:8080/micron/photos'
curl --location --request GET 'http://localhost:8080/micron/photos/1'
curl --location --request GET 'http://localhost:8080/micron/albums/12/photos'

D)
D1)
curl --location --request POST 'http://localhost:8080/micron/getTodoById' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getTodoById(id: 23) {
        id
        title        
        completed                
    }
}'

D2)
curl --location --request POST 'http://localhost:8080/micron/getTodosByUserId' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getTodosByUserId(userId: 1) {
        userId
        title        
        completed                
    }
}'

D3) 
curl --location --request POST 'http://localhost:8080/micron/getAllTodos' \
--header 'Content-Type: text/plain' \
--data-raw '{
    getAllTodos {
        userId
        title        
        completed                
    }
}'

D4)
curl --location --request GET 'http://localhost:8080/micron/todos'
curl --location --request GET 'http://localhost:8080/micron/users/5/todos'
curl --location --request GET 'http://localhost:8080/micron/todos/42'