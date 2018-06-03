package com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Fernando on 03/06/2018.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.app.repository2",mongoTemplateRef = SecondaryMongoConfig.MONGO_TEMPLATE)
public class SecondaryMongoConfig {
    protected static final String MONGO_TEMPLATE ="secondaryMongoTemplate";
}
