package com.example.review.model;

import com.example.review.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"person_id", "cart_id"})})
public class Comment extends BaseEntity<Integer> {
    @Column(columnDefinition = "varchar(500)")
    private String description;
    @Column(columnDefinition = "boolean default FALSE")
    private Boolean isChecked;
    @Column(columnDefinition = "boolean default FALSE")
    private Boolean isApproved = false;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
