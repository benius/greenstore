package com.greenstyle.greenstore.service;

import com.greenstyle.greenstore.model.PageLink;

import java.util.List;

/**
 * <code>PageLinkService</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
public interface PageLinkService {

    Iterable<PageLink> findAllPageLinks();

    PageLink findPageLinkByName(String name);

}
