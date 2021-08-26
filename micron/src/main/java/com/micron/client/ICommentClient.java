package com.micron.client;

import com.micron.dto.CommentResponseDto;
import com.micron.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "comment-client")
public interface ICommentClient {

    @GetMapping("/comments")
    public List<CommentResponseDto> getAllComments();

    @GetMapping("/posts/{postId}/comments")
    public List<CommentResponseDto> getCommentsByPostId(@PathVariable Integer postId);

    @GetMapping("/comments/{id}")
    public CommentResponseDto getCommentById(@PathVariable Integer id);
}
