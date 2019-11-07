package com.greenstyle.greenstore.model;

import java.io.Serializable;

/**
 * <code>PageLink</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
public class PageLink implements Serializable {
    private static final long serialVersionUID = 4234033770385016776L;

    private String name;
    private String label;
    private String iconUri;
    private String pageUri;

    public PageLink(String name, String label, String iconUri, String pageUri) {
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
