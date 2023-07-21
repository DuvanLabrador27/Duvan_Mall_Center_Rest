package com.duvanlabrador.api_rest_products.service;

import com.duvanlabrador.api_rest_products.dto.CommentsDTO;
import com.duvanlabrador.api_rest_products.entities.CommentsEntity;
import com.duvanlabrador.api_rest_products.entities.ProductEntity;
import com.duvanlabrador.api_rest_products.repository.CommentsRepository;
import com.duvanlabrador.api_rest_products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;
    private final ProductRepository productRepository;
    @Autowired
    public CommentsServiceImpl(CommentsRepository commentsRepository, ProductRepository productRepository){
        this.commentsRepository = commentsRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CommentsDTO createCommentToProduct(String referenceId, CommentsDTO commentsDTO) {
        CommentsEntity comments = mapToEntity(commentsDTO);
        ProductEntity productEntity = productRepository.findByReferenceId(referenceId);
        comments.setProductEntity(productEntity);
        CommentsEntity commentsEntity = commentsRepository.save(comments);
        return mapToDTO(commentsEntity);
    }

    @Override
    public List<CommentsDTO> getAllComments(String referenceId) {
        List<CommentsEntity> comments = commentsRepository.findByProductEntity_ReferenceId(referenceId);
        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
    }

    @Override
    public List<CommentsDTO> getAllCommentsForIdCount(Long idCount) {
        List<CommentsEntity> comments = commentsRepository.findByProductEntityIdCount(idCount);
        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentsDTO getCommentForId(Long reference_Id, Long commentId) {
        ProductEntity product = productRepository.findById(reference_Id).orElseThrow();
        CommentsEntity commentsEntity = commentsRepository.findById(commentId).orElseThrow();
        if (!commentsEntity.getProductEntity().getIdCount().equals(product.getIdCount())){
            throw new RuntimeException("the commentary don't belong to product");
        }
        return mapToDTO(commentsEntity);
    }
    @Transactional
    public CommentsDTO mapToDTO(CommentsEntity commentsEntity){
            CommentsDTO comments = new CommentsDTO();
            comments.setIdComment(commentsEntity.getIdComment());
            comments.setCommentBody(commentsEntity.getCommentBody());
            comments.setEmail(commentsEntity.getEmail());
            comments.setCommentTittle(commentsEntity.getCommentTittle());

            return comments;
    }

    public CommentsEntity mapToEntity(CommentsDTO commentsDTO){
        CommentsEntity comments = new CommentsEntity();
        comments.setCommentBody(commentsDTO.getCommentBody());
        comments.setEmail(commentsDTO.getEmail());
        comments.setCommentTittle(commentsDTO.getCommentTittle());
        return comments;
    }

}
