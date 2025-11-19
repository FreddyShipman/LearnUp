package com.learnup.config;

/**
 *
 * @author alfre
 */

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Conexion {
    private static Conexion instance;
    private MongoClient client;
    private MongoDatabase database;
    private final String DB_NAME = "LearnUpDB";

    private Conexion() {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://localhost:27017"))
                .codecRegistry(codecRegistry)
                .build();

        client = MongoClients.create(settings);
        database = client.getDatabase(DB_NAME);
    }

    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public <T> MongoCollection<T> getCollection(String name, Class<T> resultClass) {
        return database.getCollection(name, resultClass);
    }
}