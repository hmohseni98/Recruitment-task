package com.example.review.service.dto.vote;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VoteProductManagerDTO {
    private Integer id;
    private Integer rating;
    private String personFirstName;
    private String personLastName;
    private String productName;
}
