package com.example.review.model;

import com.example.review.model.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Vote extends BaseEntity<Integer> {
    @Min(value = 0, message = "rating can between 0 to 5")
    @Max(value = 5, message = "rating can between 0 to 5")
    private Integer rating;
    @Column(columnDefinition = "boolean default FALSE")
    private Boolean isChecked;
    @Column(columnDefinition = "boolean default FALSE")
    private Boolean isApproved;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

}
