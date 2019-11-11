package com.greenstyle.greenstore.service;

import com.greenstyle.greenstore.dao.ProductDao;
import com.greenstyle.greenstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Optional;

/**
 * <code>ProductServiceImpl</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
@Service("productService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductServiceImpl implements ProductService, Serializable {
    private static final long serialVersionUID = 99876389459348791L;

    private ProductDao productDao;

    public ProductServiceImpl(@Autowired ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void createProduct(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public Iterable<Product> findAllProducts() throws Exception {
        return productDao.findAll();
    }

    @Override
    public Iterable<Product> findByProductNameKeyword(String keyword) throws Exception {
        if (StringUtils.isEmpty(keyword)) {
            return productDao.findAll();
        }

        return productDao.findByProductNameContainingIgnoreCase(keyword);
    }

    @Override
    public Optional<Product> findById(String productId) throws Exception {
        if (StringUtils.isEmpty(productId)) {
            return Optional.empty();
        }

        return productDao.findById(productId);
    }

    @Override
    public void createOrUpdate(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public boolean existsById(String productId) throws Exception {
        return productDao.existsById(productId);
    }
}
