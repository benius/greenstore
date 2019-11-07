package com.greenstyle.greenstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <code>Product</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String productName;
    private Long price;
    private String description;
    private String imageName;

    protected Product() {}

    public Product(String productName, Long price, String imageName, String description) {
        this.productName = productName;
        this.price = price;
        this.imageName = imageName;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Product[id=%s, name=%s, price=%d, image=%s, description=%s]", id, productName, price, imageName, description);
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImageName() {
        return imageName;
    }
}
