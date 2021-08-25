package com.micron.controller;

import com.micron.dto.CommentResponseDto;
import com.micron.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/micron")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/comments")
    public List<CommentResponseDto> getComments(){
        return commentService.getComments();
    }
}
