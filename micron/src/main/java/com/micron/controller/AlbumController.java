package com.micron.controller;

import com.micron.dto.AlbumResponseDto;
import com.micron.service.IAlbumService;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/micron")
public class AlbumController {

    @Autowired
    private IAlbumService albumService;

    @Value("classpath:album.graphqls")
    private Resource schemaResource;

    private GraphQL graphQL;

    // Common code - Need to load this code while application is initialized
    @PostConstruct
    public void loadSchema() throws IOException {
        File schemaFile = schemaResource.getFile();
        TypeDefinitionRegistry registry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    // Wiring the DTO with GraphQL File
    private RuntimeWiring buildWiring() {
        DataFetcher<List<AlbumResponseDto>> fetcher1 = data -> {
            return (List<AlbumResponseDto>) albumService.getAlbums();
        };

        DataFetcher<List<AlbumResponseDto>> fetcher2 = data -> {
            return albumService.getAlbumsByUserId(data.getArgument("userId"));
        };

        DataFetcher<AlbumResponseDto> fetcher3 = data -> {
            return albumService.getAlbumById(data.getArgument("id"));
        };

        return RuntimeWiring.newRuntimeWiring().type("Query",
                typeWriting -> typeWriting
                        .dataFetcher("getAllAlbums", fetcher1)
                        .dataFetcher("getAlbumsByUserId", fetcher2)
                        .dataFetcher("getAlbumById", fetcher3))
                .build();
    }

    // GraphQL Supported POST API - TO GET DATA - GET ALL ALBUMS
    @PostMapping("/getAllAlbums")
    public ResponseEntity<Object> getAllAlbums(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    // GraphQL Supported POST API - TO GET DATA - GET ALBUM BY ID
    @PostMapping("/getAlbumsByUserId")
    public ResponseEntity<Object> getAlbumsByUserId(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    // GraphQL Supported POST API - TO GET DATA - GET ALBUM BY ID
    @PostMapping("/getAlbumById")
    public ResponseEntity<Object> getAlbumById(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    // Returns a list of entire albums i.e the entire AlbumResponseDTO object is contained in the list
    @GetMapping("/albums")
    public List<AlbumResponseDto> getAlbums() {
        return albumService.getAlbums();
    }

    // Returns a List of Albums which belongs to the particular userId
    @GetMapping("/users/{userId}/albums")
    public List<AlbumResponseDto> getAlbumsByUserId(@PathVariable Integer userId) {
        return albumService.getAlbumsByUserId(userId);
    }

    // Returns an Albums based on an albumId
    @GetMapping("/albums/{id}")
    public AlbumResponseDto getAlbumById(@PathVariable Integer id) {
        return albumService.getAlbumById(id);
    }
}
