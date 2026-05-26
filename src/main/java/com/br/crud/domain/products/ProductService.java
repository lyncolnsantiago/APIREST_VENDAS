package com.br.crud.domain.products;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void createProduct(ProductRequestDTO dto) {
        Product product = new Product(dto);
        repository.save(product);
    }
}
