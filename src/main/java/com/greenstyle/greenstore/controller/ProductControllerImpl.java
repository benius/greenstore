package com.greenstyle.greenstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <code>ProductControllerImpl</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
@Controller
public class ProductControllerImpl implements ProductController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("list_products")
    public String listProducts() {
        return "list_products";
    }

}
