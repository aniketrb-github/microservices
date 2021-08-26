package com.micron.controller;

import com.micron.dto.CommentResponseDto;
import com.micron.service.ICommentService;
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
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @Value("classpath:comment.graphqls")
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
        DataFetcher<List<CommentResponseDto>> fetcher1 = data -> {
            return (List<CommentResponseDto>) commentService.getAllComments();
        };

        DataFetcher<List<CommentResponseDto>> fetcher2 = data -> {
            return (List<CommentResponseDto>) commentService.getCommentsByPostId(data.getArgument("postId"));
        };

        DataFetcher<CommentResponseDto> fetcher3 = data -> {
            return commentService.getCommentById(data.getArgument("id"));
        };

        return RuntimeWiring.newRuntimeWiring().type("Query",
                typeWriting -> typeWriting
                        .dataFetcher("getAllComments", fetcher1)
                        .dataFetcher("getCommentsByPostId", fetcher2)
                        .dataFetcher("getCommentById", fetcher3))
                .build();
    }

    // GraphQL Supported POST API - TO GET DATA - GET ALL COMMENTS
    @PostMapping("/getAllComments")
    public ResponseEntity<Object> getAllComments(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    // GraphQL Supported POST API - TO GET DATA - GET ALL COMMENTS RELATED TO A PARTICULAR POST
    @PostMapping("/getCommentsByPostId")
    public ResponseEntity<Object> getCommentsByPostId(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    // GraphQL Supported POST API - TO GET DATA - GET COMMENT BY ID
    @PostMapping("/getCommentById")
    public ResponseEntity<Object> getCommentById(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    // Regular REST GET API which returns all the available comments
    @GetMapping("/comments")
    public List<CommentResponseDto> getComments(){
        return commentService.getAllComments();
    }

    // Regular REST GET API which returns a Comment based on a commentId
    @GetMapping("/comments/{id}")
    public CommentResponseDto getCommentById(@PathVariable Integer id){
        return commentService.getCommentById(id);
    }

    // Regular REST GET API which returns all comments related to a single post
    @GetMapping("/posts/{postId}/comments")
    public List<CommentResponseDto> getCommentsByPostId(@PathVariable Integer postId){
        return commentService.getCommentsByPostId(postId);
    }
}
