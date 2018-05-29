package com.dream.service.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Dream on 2018/5/17.
 *
 * @author Dream
 */
@Configuration
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.maxPoolSize}")
    private Integer maxPoolSize;
    @Value("${jdbc.minPoolSize}")
    private Integer minPoolSize;
    @Value("${jdbc.initPoolSize}")
    private int initPoolSize;
    @Value("${jdbc.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
    @Value("${jdbc.autoCommitOnClose}")
    private boolean autoCommitOnClose;
    @Value("${jdbc.timeout}")
    private int timeout;
    @Value("${jdbc.try}")
    private int jdbcTry;
    @Value("${jdbc.filter}")
    private String filter;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxPoolSize);
        dataSource.setMinIdle(minPoolSize);
        dataSource.setInitialSize(initPoolSize);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setDefaultAutoCommit(autoCommitOnClose);
        dataSource.setQueryTimeout(timeout);
        dataSource.setNotFullTimeoutRetryCount(jdbcTry);
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(50);
        dataSource.setMaxWait(1000L);
        try {
            dataSource.setFilters(filter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
