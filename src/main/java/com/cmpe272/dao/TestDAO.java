package com.cmpe272.dao;

import com.cmpe272.domain.Food;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yutao on 12/3/15.
 */
@Component
public class TestDAO {
    private static MongoCollection mongoCollection = null;
    private static ObjectMapper objectMapper = null;

    public TestDAO() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }

        if (mongoCollection == null) {
            MongoClientURI mongoClientURI = new MongoClientURI(Constant.MONGODB_URL);
            MongoClient mongoClient = new MongoClient(mongoClientURI);
            MongoDatabase mongoDatabase = mongoClient.getDatabase(Constant.DB_NAME);
            mongoCollection = mongoDatabase.getCollection("test");
        }
    }

    public List<Food> findAll() {
        List<Food> list = new ArrayList<>();
        FindIterable<Document> iterable = mongoCollection.find();
        for (Document document : iterable) {
            try {
                list.add(FoodDAO.parseFood(document));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("MM/dd/yy");
    public void changeDate() {
        FindIterable<Document> iterable = mongoCollection.find();
        for (Document document : iterable) {
            String s = document.getString("ExpirationDate");
            int rowID = document.getInteger("RowID");
            Date date = null;
            try {
                date = FORMAT.parse(s);

//                mongoCollection.updateOne(new Document("RowID", rowID),
//                        new Document("$set", new Document("Date", date)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(date);
        }
    }

    public List<Food> findByRange(Date start, Date end) {
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("Date", BasicDBObjectBuilder.start("$gte", start).add("$lte", end).get());
        FindIterable<Document> iterable = mongoCollection.find(basicDBObject);

        List<Food> list = new ArrayList<>();
        for (Document document : iterable) {
            try {
                list.add(FoodDAO.parseFood(document));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}