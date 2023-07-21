package com.duvanlabrador.api_rest_products.service;

import com.duvanlabrador.api_rest_products.dto.ProductDTO;
import com.duvanlabrador.api_rest_products.entities.ProductEntity;
import com.duvanlabrador.api_rest_products.repository.ProductRepository;
import com.duvanlabrador.api_rest_products.util.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = mapTOEntity(productDTO);
        ProductEntity newProduct = productRepository.save(productEntity);
        ProductDTO product = mapToDTO(newProduct);
        return product;
    }
    @Transactional
    @Override
    public List<ProductDTO> getAllProduct() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities.stream().map(product -> mapToDTO(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductForReference(String referenceId) {
        ProductEntity productEntity = productRepository.findByReferenceId(referenceId);
        return mapToDTO(productEntity);
    }

    @Override
    public ProductDTO getProductForId(Long idCount) {
        ProductEntity productEntity = productRepository.findById(idCount).orElseThrow();
        return mapToDTO(productEntity);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, String referenceId) {
        ProductEntity productEntity = productRepository.findByReferenceId(referenceId);
        productEntity.setProductName(productDTO.getProductName());
        productEntity.setFabricationDate(productDTO.getFabricationDate());
        productEntity.setExpirationDate(productDTO.getExpirationDate());
        productEntity.setProductPrice(productDTO.getProductPrice());
        productEntity.setProductStock(productDTO.getProductStock());
        productEntity.setProductCategory(productDTO.getProductCategory());
        productEntity.setProductStatus(productDTO.getProductStatus());

        ProductEntity updateProduct = productRepository.save(productEntity);

        return mapToDTO(updateProduct);
    }

    @Override
    public void deleteProduct(String referenceId) {
       ProductEntity productEntity = productRepository.findByReferenceId(referenceId);
       productRepository.delete(productEntity);
    }

    @Override
    public void enableProduct(String referenceId) {

        productRepository.enableProduct(referenceId);
    }

    @Override
    public void disableProduct(String referenceId) {
        productRepository.disableProduct(referenceId);
    }


    @Override
    public List<ProductDTO> getProductByCategory(ProductCategory productCategory) {
        List<ProductEntity> productEntities = productRepository.findProductEntityByProductCategory(productCategory);
        return productEntities.stream().map(category -> mapToDTO(category)).collect(Collectors.toList());
    }

    @Transactional
    public ProductDTO mapToDTO(ProductEntity productEntity){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdCount(productEntity.getIdCount());
        productDTO.setReferenceId(productEntity.getReferenceId());
        productDTO.setProductName(productEntity.getProductName());
        productDTO.setFabricationDate(productEntity.getFabricationDate());
        productDTO.setExpirationDate(productEntity.getExpirationDate());
        productDTO.setProductPrice(productEntity.getProductPrice());
        productDTO.setProductStock(productEntity.getProductStock());
        productDTO.setProductCategory(productEntity.getProductCategory());
        productDTO.setProductStatus(productEntity.getProductStatus());
        productDTO.setComments(productEntity.getComments());
        return productDTO;
    }

    public ProductEntity mapTOEntity(ProductDTO productDTO){
        ProductEntity productEntity = new ProductEntity();

        productEntity.setReferenceId(productDTO.getReferenceId());
        productEntity.setProductName(productDTO.getProductName());
        productEntity.setFabricationDate(productDTO.getFabricationDate());
        productEntity.setExpirationDate(productDTO.getExpirationDate());
        productEntity.setProductPrice(productDTO.getProductPrice());
        productEntity.setProductStock(productDTO.getProductStock());
        productEntity.setProductCategory(productDTO.getProductCategory());
        productEntity.setProductStatus(productDTO.getProductStatus());

        return  productEntity;
    }
}
