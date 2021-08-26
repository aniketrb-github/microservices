package com.micron.service;

import com.micron.client.ICommentClient;
import com.micron.dto.CommentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentClient commentClient;

    @Override
    public List<CommentResponseDto> getAllComments() {
        return commentClient.getAllComments();
    }

    @Override
    public CommentResponseDto getCommentById(Integer id) {
        return commentClient.getCommentById(id);
    }

    @Override
    public List<CommentResponseDto> getCommentsByPostId(Integer postId) {
        return commentClient.getCommentsByPostId(postId);
    }
}
