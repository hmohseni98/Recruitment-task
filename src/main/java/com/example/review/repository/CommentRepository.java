package com.example.review.repository;

import com.example.review.model.Comment;
import com.example.review.service.dto.comment.CommentDTO;
import com.example.review.service.dto.comment.CommentProductManagerDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment,Integer>, JpaRepository<Comment,Integer> {

    @Query("select new com.example.review.service.dto.comment.CommentDTO(c.description,pe.firstName,pe.lastName ,p.name) from Comment c " +
            " join c.person pe" +
            " join c.cart ca " +
            " join ca.product p " +
            " where p.id = :productId ")
    List<CommentDTO> getLastTreeComments(@Param("productId") Integer productId , Pageable pageable);


    @Query(value = "select count(*) from comment c " +
            "inner join cart ca on c.cart_id = ca.id " +
            "inner join product p on ca.product_id = p.id " +
            "where p.id = :productId and c.is_approved = true ", nativeQuery = true)
    Integer getCountOfTotalComments(@Param("productId") Integer productId);

    @Query("select new com.example.review.service.dto.comment.CommentProductManagerDTO " +
            " (c.id,c.description,pe.firstName,pe.lastName,p.name) from Comment c " +
            " join c.person pe" +
            " join c.cart ca " +
            " join ca.product p ")
    List<CommentProductManagerDTO> getCommentsUnChecked();


}
