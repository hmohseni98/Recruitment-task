package com.example.review.service.impl;

import com.example.review.model.Product;
import com.example.review.repository.ProductRepository;
import com.example.review.service.ProductService;
import com.example.review.service.base.BaseServiceImpl;
import com.example.review.service.dto.product.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED , propagation = Propagation.REQUIRED)
public class ProductServiceImpl extends BaseServiceImpl<Product, Integer, ProductRepository>
        implements ProductService {

    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }

    @Override
    public void setVisibilityMode(Product product) {
        Product newProduct = findById(product.getId());
        newProduct.setIsVisible(product.getIsVisible());
        save(newProduct);
    }

    @Override
    public void setReviewAvailability(Product product) {
        Product newProduct = findById(product.getId());
        newProduct.setReviewAvailable(product.getReviewAvailable());
        save(newProduct);
    }

    @Override
    public void setReviewMode(Product product) {
        Product newProduct = findById(product.getId());
        newProduct.setReviewMode(product.getReviewMode());
        save(newProduct);
    }

    @Override
    public void addCommentForPaidCustomersOnly(Product product) {
        Product newProduct = findById(product.getId());
        newProduct.setIsPaidCustomerCommentAllowed(product.getIsPaidCustomerCommentAllowed());
        save(newProduct);
    }

    @Override
    public List<ProductDTO> getProductsShowable() {
        return repository.getProductsShowable();
    }

    @Override
    public List<ProductDTO> getProductsCommentable() {
        return repository.getProductsCommentable();
    }

    @Override
    public List<ProductDTO> getProductsCommentableAndVotable() {
        return repository.getProductsCommentableAndVotable();
    }

}
