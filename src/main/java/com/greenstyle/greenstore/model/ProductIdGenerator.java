package com.greenstyle.greenstore.model;


import org.apache.commons.lang3.RandomUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <code>ProductIdGenerator</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
public class ProductIdGenerator implements IdentifierGenerator {
    private static DateFormat dateFormat = new SimpleDateFormat("ssSS");
//    private static DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return String.format("%s-%d", dateFormat.format(new Date()), RandomUtils.nextInt(1000, 10000));
    }

    @Override
    public boolean supportsJdbcBatchInserts() {
        return true;
    }
}
