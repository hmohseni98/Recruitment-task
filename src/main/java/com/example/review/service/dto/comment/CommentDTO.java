package com.example.review.service.dto.comment;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDTO {
    private String description;
    private String personFirstName;
    private String personLastName;
    private String productName;
}
