package com.cmpe272.dao;

import com.cmpe272.domain.Food;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yutao on 12/3/15.
 */
@Component
public class FoodDAO {
    private static MongoCollection mongoCollection = null;
    private static ObjectMapper objectMapper = null;

    public FoodDAO() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }

        if (mongoCollection == null) {
            MongoClientURI mongoClientURI = new MongoClientURI(Constant.MONGODB_URL);
            MongoClient mongoClient = new MongoClient(mongoClientURI);
            MongoDatabase mongoDatabase = mongoClient.getDatabase(Constant.DB_NAME);
            mongoCollection = mongoDatabase.getCollection("food");
        }
    }

    public List<Food> findAll() {
        List<Food> list = new ArrayList<>();
        FindIterable<Document> iterable = mongoCollection.find().limit(10);
        for (Document document : iterable) {
            String jsonString = document.toJson();
            Food food = null;
            try {
                food = objectMapper.readValue(jsonString, Food.class);
                list.add(food);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
