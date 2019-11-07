package com.greenstyle.greenstore.dao;

import com.greenstyle.greenstore.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * <code>ProductDao</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
@Repository
public interface ProductDao extends CrudRepository<Product, String> {

    Optional<Product> findById(String id);

    Iterable<Product> findByProductNameContainingIgnoreCase(String productName);


}
