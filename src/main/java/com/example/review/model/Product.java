package com.example.review.model;

import com.example.review.model.base.BaseEntity;
import com.example.review.model.enumration.ReviewAvailable;
import com.example.review.model.enumration.ReviewMode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product extends BaseEntity<Integer> {
    @Column(columnDefinition = "varchar(150)")
    private String name;
    @Column(columnDefinition = "varchar(1000)")
    private String description;
    private Integer price;
    @Enumerated(EnumType.STRING)
    private ReviewAvailable reviewAvailable;
    @Enumerated(EnumType.STRING)
    private ReviewMode reviewMode;
    private Boolean isVisible;
    private Boolean isPaidCustomerCommentAllowed;
}
