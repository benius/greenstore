package com.greenstyle.greenstore.service;

import com.greenstyle.greenstore.model.MenuItem;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <code>menuServiceImpl</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
@Service("menuService")
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MenuServiceImpl implements MenuService, Serializable {
    private static final long serialVersionUID = 5597916778309976953L;

    private Map<String, MenuItem> menuItemMap = new LinkedHashMap<>();

    public MenuServiceImpl() {
        menuItemMap.put("hello", new MenuItem("hello", "Welcome!", "/img/people.png", "~./zul/hello.zul"));
        menuItemMap.put("list_products", new MenuItem("list_products", "Find Products", "/img/list-fat-7.png", "~./zul/list_products.zul"));
        menuItemMap.put("product_detail", new MenuItem("product_detail", "Product Detail", "/img/info.png", "~./zul/product_detail.zul?id=2"));
        menuItemMap.put("new_product", new MenuItem("new_product", "New Product", "/img/plus-sign.png", "~./zul/new_product.zul"));
        menuItemMap.put("delete_products", new MenuItem("delete_products", "Delete Products", "/img/minus-sign.png", "~./zul/delete_products.zul"));
    }

    @Override
    public Iterable<MenuItem> findAllMenuItems() {
        return menuItemMap.values();
    }

    @Override
    public MenuItem findMenuItemByName(String name) {
        return menuItemMap.get(name);
    }
}
