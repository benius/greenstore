package com.greenstyle.greenstore.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <code>Product</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
@Entity
public class Product {

    @Id
    @GenericGenerator(name="product_id_seq", strategy = "com.greenstyle.greenstore.model.ProductIdGenerator")
    @GeneratedValue(generator = "product_id_seq")
    @Column(name = "PRODUCT_ID", columnDefinition = "varchar(1024)", unique = true, nullable = false)
    private String productId;
    @Column(name = "PRODUCT_NAME", columnDefinition = "varchar(1024) CHARACTER SET utf8", unique = true, nullable = false)
    private String productName;
    @Column(name = "PRODUCT_PRICE", columnDefinition = "bigint", unique = false, nullable = false)
    private Long price;
    @Column(name = "PRODCUT_DESC", columnDefinition = "varchar(4096) CHARACTER SET utf8", unique = false, nullable = true)
    private String description;
    @Column(name = "PRODUCT_PHOTO", columnDefinition = "varchar(1024) CHARACTER SET utf8", unique = false, nullable = true)
    private String imageName;

    protected Product() {}

    public Product(String productName, Long price, String imageName, String description) {
        this.productName = productName;
        this.price = price;
        this.imageName = imageName;
        this.description = description;
    }

    public Product(String productId, String productName, Long price, String imageName, String description) {
        this(productName, price, imageName, description);

        setProductId(productId);
    }


    @Override
    public String toString() {
        return String.format("Product[productId=%s, name=%s, price=%d, image=%s, description=%s]", productId, productName, price, imageName, description);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
