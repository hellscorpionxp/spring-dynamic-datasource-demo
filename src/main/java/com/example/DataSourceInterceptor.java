package com.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author hellscorpion
 * @date 2017-05-07
 * @version 1.0
 */
@Component
@Aspect
@Order(0)
public class DataSourceInterceptor {

    @Pointcut("execution(public * com.qyer.search.dao.lastminute.**.*Mapper.*(..))")
    public void dataSourceLastminute() {
    }

    @Pointcut("execution(public * com.qyer.search.dao.marketing.**.*Mapper.*(..))")
    public void dataSourceTag() {
    }

    @Pointcut("execution(public * com.qyer.search.dao.place.**.*Mapper.*(..))")
    public void dataSourcePlace() {
    }

    @Before("dataSourceLastminute()")
    public void beforeDataSourceLastminute() {
        DataSourceContextHolder.setDataSourceType(DataSourceType.LASTMINUTE);
    }

    @Before("dataSourceTag()")
    public void beforeDataSourceTag() {
        DataSourceContextHolder.setDataSourceType(DataSourceType.TAG);
    }

    @Before("dataSourcePlace()")
    public void beforeDataSourcePlace() {
        DataSourceContextHolder.setDataSourceType(DataSourceType.PLACE);
    }

}
