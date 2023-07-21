package com.duvanlabrador.api_rest_products.controller;

import com.duvanlabrador.api_rest_products.dto.CommentsDTO;
import com.duvanlabrador.api_rest_products.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentsController {

    private final CommentsService commentsService;
    @Autowired
    public CommentsController(CommentsService commentsService){
        this.commentsService = commentsService;
    }

    @PostMapping("/createComment/{referenceId}")
    public ResponseEntity<CommentsDTO> createComment(@PathVariable String referenceId, @RequestBody CommentsDTO commentsDTO){
        try {
            CommentsDTO comments = commentsService.createCommentToProduct(referenceId,commentsDTO);
            return new ResponseEntity<>(comments, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getAllCommentByProduct/{referenceId}")
    public List<CommentsDTO> getAllCommentsForProduct(@PathVariable(value = "referenceId") String referenceId){
        return commentsService.getAllComments(referenceId);
    }

    @GetMapping("/getAllCommentForIdCount/{idCount}")
    public List<CommentsDTO> getAllCommentsForIdCount(@PathVariable(value = "idCount") Long idCount){
        return commentsService.getAllCommentsForIdCount(idCount);
    }

    @GetMapping("/product/{reference_Id}/comm/{commentId}")
    public ResponseEntity<CommentsDTO> getProductByCommentForId(
            @PathVariable(value = "reference_Id") Long reference_Id,
            @PathVariable(value = "commentId") Long commentId){
        try {
            CommentsDTO commentsDTO = commentsService.getCommentForId(reference_Id,commentId);
            return new ResponseEntity<>(commentsDTO,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

}
