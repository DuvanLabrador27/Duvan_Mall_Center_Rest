package com.duvanlabrador.api_rest_products.service;

import com.duvanlabrador.api_rest_products.dto.ProductDTO;
import com.duvanlabrador.api_rest_products.util.ProductCategory;

import java.util.List;

public interface ProductService {

    public ProductDTO createProduct(ProductDTO productDTO);
    public List<ProductDTO> getAllProduct();
    public ProductDTO getProductForReference(String referenceId);
    public ProductDTO getProductForId(Long idCount);
    public ProductDTO updateProduct(ProductDTO productDTO, String referenceId);
    public void deleteProduct(String referenceId);
    public void enableProduct(String referenceId);
    public void disableProduct(String referenceId);
    public List<ProductDTO> getProductByCategory(ProductCategory productCategoryd);
}
