package com.greenstyle.greenstore.service;

import com.greenstyle.greenstore.model.PageLink;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <code><PageLinkServiceImpl/code>
 *
 * @author masonhsieh
 * @version 1.0
 */
@Service("pageLinkService")
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PageLinkServiceImpl implements PageLinkService {

    private Map<String, PageLink> pageLinkMap = new LinkedHashMap<>();

    public PageLinkServiceImpl() {
        pageLinkMap.put("hello", new PageLink("hello", "Welcome!", "/img/demo.png", "~./zul/hello.zul"));
        pageLinkMap.put("list_products", new PageLink("list_products", "Find Products", "/img/site.png", "~./zul/list_products.zul"));
    }

    @Override
    public Iterable<PageLink> findAllPageLinks() {
        return pageLinkMap.values();
    }

    @Override
    public PageLink findPageLinkByName(String name) {
        return pageLinkMap.get(name);
    }
}
