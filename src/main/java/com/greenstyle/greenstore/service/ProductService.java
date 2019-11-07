package com.greenstyle.greenstore.service;

import com.greenstyle.greenstore.model.Product;

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

}
