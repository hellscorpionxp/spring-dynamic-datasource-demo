package com.example;

import static org.junit.Assert.assertNotNull;

/**
 * @author wangyuan
 * @date 2017年5月3日
 * @version 1.0
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

    public static DataSourceType getDataSourceType() {
        return contextHolder.get();
    }

    public static void setDataSourceType(DataSourceType dataSourceType) {
        assertNotNull("dataSourceType cannot be bull.", dataSourceType);
        contextHolder.set(dataSourceType);
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }

}
