package com.micron.controller;

import com.micron.dto.TodoResponseDto;
import com.micron.service.ITodoService;
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
public class TodoController {

    @Autowired
    private ITodoService todoService;

    @Value("classpath:todo.graphqls")
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
        DataFetcher<List<TodoResponseDto>> fetcher1 = data -> {
            return (List<TodoResponseDto>) todoService.getAllTodos();
        };

        DataFetcher<List<TodoResponseDto>> fetcher2 = data -> {
            return todoService.getTodosByUserId(data.getArgument("userId"));
        };

        DataFetcher<TodoResponseDto> fetcher3 = data -> {
            return todoService.getTodoById(data.getArgument("id"));
        };

        return RuntimeWiring.newRuntimeWiring().type("Query",
                typeWriting -> typeWriting
                        .dataFetcher("getAllTodos", fetcher1)
                        .dataFetcher("getTodosByUserId", fetcher2)
                        .dataFetcher("getTodoById", fetcher3))
                .build();
    }

    // GraphQL Supported POST API - TO GET DATA - GET ALL TODOS
    @PostMapping("/getAllTodos")
    public ResponseEntity<Object> getAllAlbums(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    // GraphQL Supported POST API - TO GET DATA - GET TODOS BY ID
    @PostMapping("/getTodosByUserId")
    public ResponseEntity<Object> getTodosByUserId(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    @PostMapping("/getTodoById")
    public ResponseEntity<Object> getTodoById(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public List<TodoResponseDto> getTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/users/{userId}/todos")
    public List<TodoResponseDto> getTodosByUserId(@PathVariable Integer userId) {
        return todoService.getTodosByUserId(userId);
    }

    @GetMapping("/todos/{id}")
    public TodoResponseDto getTodoById(@PathVariable Integer id) {
        return todoService.getTodoById(id);
    }
}
