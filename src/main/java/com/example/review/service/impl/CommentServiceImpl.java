package com.example.review.service.impl;

import com.example.review.model.Comment;
import com.example.review.repository.CommentRepository;
import com.example.review.service.CommentService;
import com.example.review.service.base.BaseServiceImpl;
import com.example.review.service.dto.comment.CommentDTO;
import com.example.review.service.dto.comment.CommentProductManagerDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED , propagation = Propagation.REQUIRED)
public class CommentServiceImpl extends BaseServiceImpl<Comment, Integer, CommentRepository>
        implements CommentService {

    public CommentServiceImpl(CommentRepository repository) {
        super(repository);
    }

    @Override
    public List<CommentDTO> getLastTreeComments(Integer productId) {
        Pageable pageable =   PageRequest.of(0, 3, Sort.by("id").descending());
        return repository.getLastTreeComments(productId,pageable);

    }

    @Override
    public Integer getCountOfTotalComments(Integer productId) {
        return repository.getCountOfTotalComments(productId);
    }

    @Override
    public List<CommentProductManagerDTO> getUnCheckedComments() {
        return repository.getCommentsUnChecked();
    }

    @Override
    public void update(Comment comment) {
        Comment newComment = findById(comment.getId());
        newComment.setIsApproved(comment.getIsApproved());
        newComment.setIsChecked(true);
        super.update(newComment);
    }

}
