package com.duvanlabrador.api_rest_products.controller;

import com.duvanlabrador.api_rest_products.dto.ProductDTO;
import com.duvanlabrador.api_rest_products.service.ProductService;
import com.duvanlabrador.api_rest_products.util.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/getAllProduct")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProduct();
    }

    @GetMapping("/reference/{referenceId}")
    public ResponseEntity<ProductDTO> getReferenceProduct(@PathVariable String referenceId){
        try {
            ProductDTO product = productService.getProductForReference(referenceId);
            return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{idCount}")
    public ResponseEntity<ProductDTO> getProductForId(@PathVariable Long idCount){
        try {
            ProductDTO product = productService.getProductForId(idCount);
            return new ResponseEntity<ProductDTO>(product,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getProductByCategory/{productCategory}")
    public List<ProductDTO> getProductByCategory(@PathVariable ProductCategory productCategory) {

        return productService.getProductByCategory(productCategory);
    }


    @PostMapping("/createProduct")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        try {
            ProductDTO product = productService.createProduct(productDTO);
            return new ResponseEntity<ProductDTO>(product, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<ProductDTO>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/updateProduct/{referenceId}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable String referenceId){
        try {
            ProductDTO product = productService.updateProduct(productDTO,referenceId);
            return new ResponseEntity<ProductDTO>(product,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<ProductDTO>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/productEnable/{referenceId}")
    public ResponseEntity<?> enableProduct(@PathVariable String referenceId){
        try {
            productService.enableProduct(referenceId);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/productDisable/{referenceId}")
    public ResponseEntity<?> disableProduct(@PathVariable String referenceId){
        try {
            productService.disableProduct(referenceId);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteProduct/{referenceId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String referenceId){
        try {
            productService.deleteProduct(referenceId);
            return new ResponseEntity<String>("The product has been delete correctly", HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.CONFLICT);
        }
    }

}
