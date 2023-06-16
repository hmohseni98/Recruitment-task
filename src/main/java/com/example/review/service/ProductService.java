package com.example.review.service;

import com.example.review.model.Product;
import com.example.review.service.base.BaseService;
import com.example.review.service.dto.product.ProductDTO;

import java.util.List;

public interface ProductService extends BaseService<Product, Integer> {

    void setVisibilityMode(Product product);

    void setReviewAvailability(Product product);

    void setReviewMode(Product product);

    void addCommentForPaidCustomersOnly(Product product);

    List<ProductDTO> getProductsShowable();

    List<ProductDTO> getProductsCommentable();

    List<ProductDTO> getProductsCommentableAndVotable();

}
