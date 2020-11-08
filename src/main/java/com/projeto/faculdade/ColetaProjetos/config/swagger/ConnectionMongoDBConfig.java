package com.projeto.faculdade.ColetaProjetos.config.swagger;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectionMongoDBConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    public MongoClient connectionMongoConfig(){
        return new MongoClient(new MongoClientURI(mongoUri));
    }
}
