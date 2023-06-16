package com.example.review.model;

import com.example.review.model.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Person extends BaseEntity<Integer> {
    @Column(columnDefinition = "varchar(40)" , nullable = false)
    private String firstName;
    @Column(columnDefinition = "varchar(60)" , nullable = false)
    private String lastName;
    private Boolean isCustomer;
}
