package com.greenstyle.greenstore.controller;

import com.greenstyle.greenstore.model.Product;
import com.greenstyle.greenstore.service.ProductService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import java.util.List;

/**
 * <code>ProductSelectorComposer</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
@VariableResolver(DelegatingVariableResolver.class)
public class ProductSelectorComposer extends SelectorComposer<Component> {
    private static final long serialVersionUID = 3147002810351788449L;

    @Wire
    private Textbox keywordBox;

    @Wire
    private Listbox productListbox;

    @WireVariable
    private ProductService productService;

    public ProductSelectorComposer() {
    }

    @Listen("onClick = #searchButton")
    public void searchProducts() throws Exception {
        String keyword = keywordBox.getValue();
        Iterable<Product> resultIterable = productService.findByProductNameKeyword(keyword);
        List<Product> resultList = IterableUtils.toList(resultIterable);
        productListbox.setModel(new ListModelList<>(resultList));
    }
}
