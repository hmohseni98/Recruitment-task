package com.example.review.repository;

import com.example.review.model.Product;
import com.example.review.service.dto.product.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p.reviewMode FROM Product p WHERE p.id = :productId")
    String getReviewModeByProductId(@Param("productId") Integer productId);

    @Query("SELECT new com.example.review.service.dto.product.ProductDTO " +
            " (p.name,p.description,p.price) FROM Product p " +
            "  WHERE p.isVisible = true ")
    List<ProductDTO> getProductsShowable();

    @Query("SELECT new com.example.review.service.dto.product.ProductDTO(p.name,p.description,p.price) FROM Product p " +
            " WHERE p.isVisible AND p.reviewAvailable = 'ONLY_COMMENT'")
    List<ProductDTO> getProductsCommentable();

    @Query("SELECT new com.example.review.service.dto.product.ProductDTO(p.name,p.description,p.price) FROM Product p " +
            " WHERE p.isVisible AND p.reviewAvailable = 'COMMENT_AND_VOTE'")
    List<ProductDTO> getProductsCommentableAndVotable();

}
