package com.greenstyle.greenstore.constraints;

import org.springframework.util.ObjectUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Constraint;

/**
 * <code>ProductPriceConstraint</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
public class ProductPriceConstraint implements Constraint {
    @Override
    public void validate(Component comp, Object value) throws WrongValueException {
        // The int value must be the multiple of 5, e.g. 5, 10, 15, ...
        if (ObjectUtils.isEmpty(value) || new Integer(value.toString()) % 5 != 0) {
            throw new WrongValueException(comp, String.format("The value \"%s\" must be an integer, and the multiple of 5, e.g. 5, 10, 15, ...", value.toString()));
        }
    }
}
