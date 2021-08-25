package com.micron.service;

import com.micron.client.ICommentClient;
import com.micron.dto.CommentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentClient commentClient;

    @Override
    public List<CommentResponseDto> getComments(){
        return commentClient.getComments();
    }
}
