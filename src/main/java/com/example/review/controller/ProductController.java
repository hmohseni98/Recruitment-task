package com.example.review.controller;

import com.example.review.model.Product;
import com.example.review.model.enumration.ReviewAvailable;
import com.example.review.model.enumration.ReviewMode;
import com.example.review.service.ProductService;
import com.example.review.service.dto.product.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("setVisibilityMode")
    @ResponseStatus(HttpStatus.OK)
    public void setVisibilityMode
            (@RequestParam Integer productId, @RequestParam Boolean isVisible) {
        Product product = new Product();
        product.setId(productId);
        product.setIsVisible(isVisible);
        productService.setVisibilityMode(product);
    }

    @PostMapping("setReviewAvailability")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product> setReviewAvailability
            (@RequestParam Integer productId, @RequestParam String reviewAvailability) {
        Product product = new Product();
        product.setId(productId);
        switch (reviewAvailability) {
            case "ONLY_COMMENT":
                product.setReviewAvailable(ReviewAvailable.ONLY_COMMENT);
                productService.setReviewAvailability(product);
                break;
            case "ONLY_VOTE":
                product.setReviewAvailable(ReviewAvailable.ONLY_VOTE);
                productService.setReviewAvailability(product);
                break;
            case "COMMENT_AND_VOTE":
                product.setReviewAvailable(ReviewAvailable.COMMENT_AND_VOTE);
                productService.setReviewAvailability(product);
                break;
            case "DEACTIVATE":
                product.setReviewAvailable(ReviewAvailable.DEACTIVATE);
                productService.setReviewAvailability(product);
                break;
            default:
                return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }


    @PostMapping("setReviewMode")
    public ResponseEntity<Product> setReviewMode(@RequestParam Integer productId,
                                                 @RequestParam String reviewMode) {
        Product product = new Product();
        product.setId(productId);
        switch (reviewMode) {
            case "PUBLIC_MODE":
                product.setReviewMode(ReviewMode.PUBLIC_MODE);
                productService.setReviewMode(product);
                break;
            case "CUSTOMER_MODE":
                product.setReviewMode(ReviewMode.CUSTOMER_MODE);
                productService.setReviewMode(product);
                break;
            default:
                return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("addCommentForPaidCustomersOnly")
    @ResponseStatus(HttpStatus.OK)
    public void addCommentForPaidCustomersOnly
            (@RequestParam Integer productId, @RequestParam Boolean value) {
        Product product = new Product();
        product.setId(productId);
        product.setIsPaidCustomerCommentAllowed(value);
        productService.addCommentForPaidCustomersOnly(product);
    }


    @GetMapping("getProductShowable")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getProductsShowable() {
        return productService.getProductsShowable();
    }

    @GetMapping("getProductsCommentable")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getProductsCommentabl() {
        return productService.getProductsCommentable();
    }

    @GetMapping("getProductsCommentableAndVotable")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getProductsCommentableAndVotable() {
        return productService.getProductsCommentableAndVotable();
    }
}
