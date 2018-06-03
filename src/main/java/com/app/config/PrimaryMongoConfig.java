package com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Fernando on 03/06/2018.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.app.repository",mongoTemplateRef = PrimaryMongoConfig.MONGO_TEMPLATE)
public class PrimaryMongoConfig {
    protected static final String MONGO_TEMPLATE ="primaryMongoTemplate";
}
