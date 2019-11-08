package com.greenstyle.greenstore.model;

import java.io.Serializable;

/**
 * <code>MenuItem</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
public class MenuItem implements Serializable {
    private static final long serialVersionUID = 5426754824625310377L;

    private String name;
    private String label;
    private String iconUri;
    private String pageUri;

    public MenuItem(String name, String label, String iconUri, String pageUri) {
        this.name = name;
        this.label = label;
        this.iconUri = iconUri;
        this.pageUri = pageUri;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getIconUri() {
        return iconUri;
    }

    public String getPageUri() {
        return pageUri;
    }
}
