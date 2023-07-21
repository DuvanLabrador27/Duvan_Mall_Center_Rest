package com.duvanlabrador.api_rest_products.service;

import com.duvanlabrador.api_rest_products.dto.CommentsDTO;
import com.duvanlabrador.api_rest_products.entities.CommentsEntity;

import java.util.List;

public interface CommentsService {

    public CommentsDTO createCommentToProduct(String referenceId, CommentsDTO commentsDTO);
    public List<CommentsDTO> getAllComments(String referenceId);
    public List<CommentsDTO> getAllCommentsForIdCount(Long idCount);
    public CommentsDTO getCommentForId(Long reference_Id, Long commentId);
}
