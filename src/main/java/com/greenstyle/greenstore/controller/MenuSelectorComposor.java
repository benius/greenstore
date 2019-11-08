package com.greenstyle.greenstore.controller;

import com.greenstyle.greenstore.model.MenuItem;
import com.greenstyle.greenstore.service.MenuService;
import org.springframework.util.StringUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.*;

/**
 * <code>MenuSelectorComposor</code> is the controller for Menu.
 *
 * @author masonhsieh
 * @version 1.0
 */
@VariableResolver(DelegatingVariableResolver.class)
public class MenuSelectorComposor extends SelectorComposer<Component> {
    private static final long serialVersionUID = 7277596565005697747L;

    @Wire
    private Grid menuGrid;

    @WireVariable("menuService")
    private MenuService menuService;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        Rows rows = menuGrid.getRows();
        menuService.findAllMenuItems().forEach(menuItem -> {
            Row row = createRowWithMenuItem(menuItem);
            rows.appendChild(row);
        });
    }

    private Row createRowWithMenuItem(MenuItem menuItem) {
        Row row = new Row();

        row.setSclass("sidebar-fn");

        Image image = new Image(menuItem.getIconUri());
        Label label = new Label(menuItem.getLabel());
        row.appendChild(image);
        row.appendChild(label);

        row.addEventListener(Events.ON_CLICK, new SerializableEventListener<Event>() {
            private static final long serialVersionUID = -8956198991752463811L;

            @Override
            public void onEvent(Event event) throws Exception {
                String pageUri = menuItem.getPageUri();

                if (!StringUtils.isEmpty(pageUri)) {
                    Executions.getCurrent().sendRedirect(pageUri);
                } 
            }
        });

        return row;
    }
}
