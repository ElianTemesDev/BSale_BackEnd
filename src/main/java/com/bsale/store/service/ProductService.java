package com.bsale.store.service;

import com.bsale.store.dto.ProductDTO;
import com.bsale.store.entity.Product;
import com.bsale.store.exception.ResourceNotFoundEx;
import com.bsale.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productsDTO = new ArrayList<>();
        products.forEach(product -> productsDTO.add(mapProductToProductDTO(product)));
        return productsDTO;
    }

    public ProductDTO getProductById(long id){
        Product product = productRepository.findById(id).orElseThrow( () ->
                new ResourceNotFoundEx("Product", "ID", id));
        return mapProductToProductDTO(product);
    }

    private ProductDTO mapProductToProductDTO(Product product){
        return new ProductDTO(product.getId(), product.getName(),
                product.getUrlImage(), product.getPrice(), product.getDiscount(), product.getCategory());
    }

    public List<ProductDTO> searchProductByCategory(long categoryId){
        List<ProductDTO> productsDTO = new ArrayList<>();
        productRepository.findAll().forEach(product -> {
            if(product.getCategory().getId() != categoryId){
                throw new ResourceNotFoundEx("ProductInCategory", "CATEGORY_ID", categoryId);
            }
            productsDTO.add(mapProductToProductDTO(product));
        });
        return productsDTO;
    }

    public List<ProductDTO> searchProductByName(String name) {
        List<ProductDTO> productsDTO = new ArrayList<>();
        productRepository.findAll().forEach(product -> {
            if(product.getName().contains(name)){
                productsDTO.add(mapProductToProductDTO(product));
            }
        });
        return productsDTO;
    }

    public List<ProductDTO> searchProductByNameAndCategory(String name, long id){
        List<ProductDTO> productsDTO = new ArrayList<>();
        searchProductByCategory(id).forEach(product -> {
            if(product.getName().contains(name)){
                productsDTO.add(product);
            }
        });
        return productsDTO;
    }
}
