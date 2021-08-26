package com.micron.controller;

import com.micron.dto.PhotoResponseDto;
import com.micron.service.IPhotoService;
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
public class PhotoController {

    @Autowired
    private IPhotoService photoService;

    @Value("classpath:photo.graphqls")
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
        DataFetcher<List<PhotoResponseDto>> fetcher1 = data -> {
            return (List<PhotoResponseDto>) photoService.getAllPhotos();
        };

        DataFetcher<List<PhotoResponseDto>> fetcher2 = data -> {
            return (List<PhotoResponseDto>) photoService.getPhotosByAlbumId(data.getArgument("albumId"));
        };

        DataFetcher<PhotoResponseDto> fetcher3 = data -> {
            return photoService.getPhotoById(data.getArgument("id"));
        };

        return RuntimeWiring.newRuntimeWiring().type("Query",
                typeWriting -> typeWriting
                        .dataFetcher("getAllPhotos", fetcher1)
                        .dataFetcher("getPhotosByAlbumId", fetcher2)
                        .dataFetcher("getPhotoById", fetcher3))
                .build();
    }

    // GraphQL Supported POST API - TO GET DATA - GET ALL PHOTOS
    @PostMapping("/getAllPhotos")
    public ResponseEntity<Object> getAllPhotos(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    @PostMapping("/getPhotosByAlbumId")
    public ResponseEntity<Object> getPhotosByAlbumId(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    // GraphQL Supported POST API - TO GET DATA - GET PHOTO BY ID
    @PostMapping("/getPhotoById")
    public ResponseEntity<Object> getPhotoById(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    // REGULAR GET API CALL
    @GetMapping("/photos")
    public List<PhotoResponseDto> getAllPhotos() {
        return photoService.getAllPhotos();
    }

    // REGULAR GET API CALL
    @GetMapping("/albums/{albumId}/photos")
    public List<PhotoResponseDto> getPhotosByAlbumId(@PathVariable Integer albumId) {
        return photoService.getPhotosByAlbumId(albumId);
    }

    // REGULAR GET API CALL
    @GetMapping("/photos/{id}")
    public PhotoResponseDto getPhotoById(@PathVariable Integer id) {
        return photoService.getPhotoById(id);
    }
}
