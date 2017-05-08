package com.example;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author wangyuan
 * @date 2017年5月3日
 * @version 1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#
     * determineCurrentLookupKey()
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSourceType();
    }

}
