package com.greenstyle.greenstore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

/**
 * <code>MetadataDaoImpl</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
@Repository
public class MetaDataDaoImpl implements MetaDataDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public boolean checkIfTableExists(String tableName) throws Exception {
        boolean result = false;

        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        ResultSet tables = metaData.getTables(null, null, null, new String[] {"TABLE"});
        for (; tables.next(); ) {
            String foundTableName = tables.getString("TABLE_NAME");
            if (foundTableName != null && foundTableName.toLowerCase().equals(tableName.toLowerCase())) {
                result = true;
                break;
            }
        }

        return result;
    }
}
