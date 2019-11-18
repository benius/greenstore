package com.greenstyle.greenstore.controller;

import com.greenstyle.greenstore.model.Product;
import com.greenstyle.greenstore.service.ProductService;
import org.apache.commons.collections4.IterableUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Set;

/**
 * <code>ProductSelectorComposer</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
@VariableResolver(DelegatingVariableResolver.class)
public class DeleteProductSelectorComposer extends SelectorComposer<Component> {
    private static final long serialVersionUID = 3147002810351788449L;

    @Wire
    private Textbox keywordBox;

    @Wire
    private Listbox productListbox;

    @WireVariable
    private ProductService productService;

    public DeleteProductSelectorComposer() {
    }

    @Listen("onClick = #searchButton")
    public void searchProducts() throws Exception {
        String keyword = keywordBox.getValue();
        Iterable<Product> resultIterable = productService.findByProductNameKeyword(keyword);
        List<Product> resultList = IterableUtils.toList(resultIterable);

        ListModelList<Product> productModel = new ListModelList<>(resultList);
        // If not set to true, the listbox changed back to single selection (radio button displays instead of check box)
        productModel.setMultiple(true);
        
        productListbox.setModel(productModel);
    }

    @Listen("onClick = #deleteButton")
    public void deleteSelectedProducts() throws Exception {
        ListModel<Product> productModel = productListbox.getModel();
        Set<Product> selectProducts = ((ListModelList<Product>) productModel).getSelection();
        selectProducts.stream().map(Product::getProductId).forEach(productId -> {
            try {
                productService.deleteById(productId);
            } catch (Exception e) {
                throw new PersistenceException(e);
            }
        });
    }
}
