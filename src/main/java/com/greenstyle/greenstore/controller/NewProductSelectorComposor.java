package com.greenstyle.greenstore.controller;

import com.greenstyle.greenstore.model.Product;
import com.greenstyle.greenstore.service.ProductService;
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

/**
 * <code>NewProductSelectorComposor</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
@VariableResolver(DelegatingVariableResolver.class)
public class NewProductSelectorComposor extends SelectorComposer<Component> {
    private static final long serialVersionUID = 3894750672333320488L;

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

    public NewProductSelectorComposor() {
    }

    @Listen("onClick = #saveProduct")
    public void saveProduct() throws Exception {
        String productName =  productNameTextbox.getValue().trim();
        Long productPrice = productPriceIntbox.getValue();
        String productImageName = productImageTextbox.getValue().trim();
        String productDescription = productDescriptionTextbox.getValue().trim();

        Product product = new Product(productName, productPrice, productImageName, productDescription);
        product = productService.createOrUpdate(product);

        productIdLabel.setValue(product.getId());
        productNameTextbox.setValue(product.getProductName());
        productPriceIntbox.setValue(product.getPrice());
        productImageTextbox.setValue(product.getImageName());
        productDescriptionTextbox.setValue(product.getDescription());
    }
}
