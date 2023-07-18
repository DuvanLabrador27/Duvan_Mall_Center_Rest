package com.duvanlabrador.api_rest_products.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDTO {
    private Long idComment;
    private String commentTittle;
    private String commentBody;
    @Email
    private String email;
}
