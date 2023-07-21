package com.duvanlabrador.api_rest_products.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private Long idComment;
    @Column(name = "comment_tittle", nullable = false)
    private String commentTittle;
    @Column(name = "comment_body", nullable = false)
    private String commentBody;
    @Column(nullable = false)
    @Email
    private String email;
    @JsonBackReference
    @ManyToOne(targetEntity = ProductEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "reference_Id")
    private ProductEntity productEntity;

}
