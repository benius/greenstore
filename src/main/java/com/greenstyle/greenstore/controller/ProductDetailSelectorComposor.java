package com.greenstyle.greenstore.controller;

import com.greenstyle.greenstore.model.Product;
import com.greenstyle.greenstore.service.ProductService;
import org.springframework.util.StringUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.Label;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Textbox;

import javax.persistence.EntityNotFoundException;

/**
 * <code>ProductDetailSelectorComposor</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
@VariableResolver(DelegatingVariableResolver.class)
public class ProductDetailSelectorComposor extends SelectorComposer<Component> {
    private static final long serialVersionUID = -1520541212904781316L;

    @Wire("#keyword")
    private Textbox keywordBox;

    @Wire("#product-id")
    private Label productIdLabel;

    @Wire("#product-name")
    private Textbox productNameTextbox;

    @Wire("#product-price")
    private Longbox productPriceIntbox;

    @Wire("#product-image")
    private Textbox productImageTextbox;

    @Wire("#product-description")
    private Textbox productDescriptionTextbox;

    @WireVariable
    private ProductService productService;

    public ProductDetailSelectorComposor() {
    }

    @Listen("onClick = #searchButton")
    public void searchProducts() throws Exception {
        String productId = keywordBox.getValue();

        if (StringUtils.isEmpty(productId)) {
            return;
        }

        productService.findById(productId).ifPresent(foundProduct -> {
            productIdLabel.setValue(foundProduct.getProductId());
            productNameTextbox.setValue(foundProduct.getProductName());
            productPriceIntbox.setValue(foundProduct.getPrice());
            productImageTextbox.setValue(foundProduct.getImageName());
            productDescriptionTextbox.setValue(foundProduct.getDescription());
        });
    }

    @Listen("onClick = #saveProduct")
    public void saveProduct() throws Exception {
        String productId = productIdLabel.getValue();

        if (!productService.existsById(productId)) {
            throw new EntityNotFoundException("Product not found with id=" + productId);
        }

        Product product = new Product(productId, productNameTextbox.getValue(), productPriceIntbox.getValue(), productImageTextbox.getValue(), productDescriptionTextbox.getValue());
        productService.createOrUpdate(product);
    }

    @Listen("onClick = #reloadProduct")
    public void reloadProduct() throws Exception {
        String productId = productIdLabel.getValue();

        if (productId == null) 

        if (!productService.existsById(productId)) {
            throw new EntityNotFoundException("Product not found with id=" + productId);
        }

        productService.findById(productId).ifPresent(foundProduct -> {
            productIdLabel.setValue(foundProduct.getProductId() != null ? foundProduct.getProductId() : "");
            productNameTextbox.setValue(foundProduct.getProductName());
            productPriceIntbox.setValue(foundProduct.getPrice());
            productImageTextbox.setValue(foundProduct.getImageName());
            productDescriptionTextbox.setValue(foundProduct.getDescription());
        });
    }
}
