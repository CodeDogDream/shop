package com.dream.service.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Dream on 2018/5/17.
 *
 * @author Dream
 */
@Configuration
@MapperScan("com.dream.service.dao")
public class MyBatisConfig {
}
