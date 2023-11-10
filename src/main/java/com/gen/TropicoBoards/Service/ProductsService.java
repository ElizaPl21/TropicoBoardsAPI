package com.gen.TropicoBoards.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gen.TropicoBoards.Model.Products;
import com.gen.TropicoBoards.Repository.ProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Products createProduct(Products product) {
        return productsRepository.save(product);
    }

    public Products updateProduct(Products product) {
        return productsRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        productsRepository.deleteById(productId);
    }

    public Optional<Products> getProductById(Long productId) {
        return productsRepository.findById(productId);
    }

    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }
}