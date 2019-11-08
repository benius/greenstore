package com.greenstyle.greenstore.service;

import com.greenstyle.greenstore.model.MenuItem;

/**
 * <code>menuService</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
public interface MenuService {

    Iterable<MenuItem> findAllMenuItems();

    MenuItem findMenuItemByName(String name);

}
