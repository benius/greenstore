package com.greenstyle.greenstore.service;

import com.greenstyle.greenstore.model.Product;

import java.util.Optional;

/**
 * <code>ProductService</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
public interface ProductService {

    void createProduct(Product product) throws Exception;

    Iterable<Product> findAllProducts() throws Exception;

    Iterable<Product> findByProductNameKeyword(String keyword) throws Exception;

    Optional<Product> findById(String productId) throws Exception;

    void createOrUpdate(Product product) throws Exception;

    boolean existsById(String productId) throws Exception;

}
