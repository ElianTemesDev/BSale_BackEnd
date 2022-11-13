package com.bsale.store.service;

import com.bsale.store.dto.ProductDTO;
import com.bsale.store.entity.Product;
import com.bsale.store.exception.ResourceNotFoundEx;
import com.bsale.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.bsale.store.predicates.ProductPredicate.containsName;
import static com.bsale.store.predicates.ProductPredicate.isOfCategory;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productsDTO = new ArrayList<>();
        products.forEach(product -> productsDTO.add(mapProductToProductDTO(product)));
        return productsDTO;
    }

    public ProductDTO getProductById(long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundEx("Product", "ID", id));
        return mapProductToProductDTO(product);
    }

    private ProductDTO mapProductToProductDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(),
                product.getUrlImage(), product.getPrice(), product.getDiscount(), product.getCategory());
    }

    public List<ProductDTO> searchProductByCategory(long categoryId) {
        List<ProductDTO> productsDTO = filterDTO(productRepository.findAll(), isOfCategory(categoryId));
        checkResourcesNotFound(productsDTO, "ProductInCategory", "CATEGORY_ID", categoryId);
        return productsDTO;
    }

    public List<ProductDTO> searchProductByName(String name) {
        List<ProductDTO> productsDTO = filterDTO(productRepository.findAll(), containsName(name));
        checkResourcesNotFound(productsDTO, "ProductByName", "name", name);
        return productsDTO;
    }

    public List<ProductDTO> searchProductByNameAndCategory(String name, long categoryId) {
        List<ProductDTO> productsDTO = filterDTO(productRepository.findAll(), isOfCategory(categoryId).and(containsName(name)));
        checkResourcesNotFound(productsDTO, "ProductInCategory", "CATEGORY_ID", categoryId);
        return productsDTO;
    }

    private void checkResourcesNotFound(List<ProductDTO> products, String resourceName, String fieldName, Object fieldVal) {
        if (products.isEmpty())
            throw new ResourceNotFoundEx(resourceName, fieldName, fieldVal);
    }

    private List<ProductDTO> filterDTO(List<Product> products, Predicate<ProductDTO> condition) {
        return products.stream().map(this::mapProductToProductDTO).filter(condition).collect(Collectors.toList());
    }
}
