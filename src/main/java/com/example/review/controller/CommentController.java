package com.example.review.controller;

import com.example.review.model.Comment;
import com.example.review.service.CommentService;
import com.example.review.service.dto.comment.CommentDTO;
import com.example.review.service.dto.comment.CommentProductManagerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("getLastTreeComments")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDTO> getLastTreeComments(@RequestParam Integer productId) {
        return commentService.getLastTreeComments(productId);
    }

    @GetMapping("getCountOfTotalComments")
    @ResponseStatus(HttpStatus.OK)
    public Integer getCountOfTotalComments(@RequestParam Integer productId) {
        return commentService.getCountOfTotalComments(productId);
    }

    @GetMapping("getUnCheckedComments")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentProductManagerDTO> getUnCheckedComments() {
        return commentService.getUnCheckedComments();
    }

    @PatchMapping("changeApprovalStatus")
    @ResponseStatus(HttpStatus.OK)
    public void changeApprovalStatus(@RequestParam Integer commentId, @RequestParam Boolean approvalStatus) {
        Comment comment = new Comment();
        comment.setId(commentId);
        comment.setIsApproved(approvalStatus);
        commentService.update(comment);
    }
}
