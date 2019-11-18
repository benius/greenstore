package com.greenstyle.greenstore.dao;

/**
 * <code>MetaDataDao</code>
 *
 * @author masonhsieh
 * @version 1.0
 */
public interface MetaDataDao {

    boolean checkIfTableExists(String tableName) throws Exception;
}
