package com.example.review.service.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentProductManagerDTO {
    private Integer id;
    private String description;
    private String personFirstName;
    private String personLastName;
    private String productName;
}
