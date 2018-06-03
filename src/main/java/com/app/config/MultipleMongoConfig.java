package com.app.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fernando on 03/06/2018.
 */
@Configuration
public class MultipleMongoConfig {

    @Autowired
    private MultipleMongoProperties mongoProperties;

    @Primary
    @Bean(name = PrimaryMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate primaryMongoTemplate() throws Exception {
        return new MongoTemplate(primaryFactory(this.mongoProperties.getPrimary()));
    }

    @Bean
    @Qualifier(SecondaryMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate secondaryMongoTemplate() throws Exception {
        return new MongoTemplate(secondaryFactory(this.mongoProperties.getSecondary()));
    }

    @Bean
    public MongoDbFactory secondaryFactory(MongoProperties secondary) {
        List<MongoCredential> list = new ArrayList<MongoCredential>();
        list.add(MongoCredential.createCredential(secondary.getUsername(),
                secondary.getDatabase(),
                secondary.getPassword()));
        MongoClient mongoClient = new MongoClient(
                new ServerAddress(
                        secondary.getHost(),
                        secondary.getPort()),list
                );

        return new SimpleMongoDbFactory(
                mongoClient,
                secondary.getDatabase());
    }

    @Bean
    @Primary
    public MongoDbFactory primaryFactory(MongoProperties primary) {
        List<MongoCredential> list = new ArrayList<MongoCredential>();
        list.add(MongoCredential.createCredential(primary.getUsername(),
                primary.getDatabase(),
                primary.getPassword()));
        MongoClient mongoClient = new MongoClient(
                new ServerAddress(
                        primary.getHost(),
                        primary.getPort()),list
        );

        return new SimpleMongoDbFactory(
                mongoClient,
                primary.getDatabase());
    }

}
