package com.example.review.service;

import com.example.review.model.Comment;
import com.example.review.service.base.BaseService;
import com.example.review.service.dto.comment.CommentDTO;
import com.example.review.service.dto.comment.CommentProductManagerDTO;

import java.util.List;

public interface CommentService extends BaseService<Comment, Integer> {
    List<CommentDTO> getLastTreeComments(Integer productId);

    Integer getCountOfTotalComments(Integer productId);

    List<CommentProductManagerDTO> getUnCheckedComments();

}
