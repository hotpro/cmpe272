package com.cmpe272.dao;

import com.cmpe272.domain.DataPoint;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 */
@Component
public class DataDAO {
    static MongoCollection mongoCollection = null;
    static ObjectMapper jacksonObjectMapper;
    public DataDAO() {
        if(jacksonObjectMapper == null) {
            jacksonObjectMapper = new ObjectMapper();
            jacksonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
        if(mongoCollection == null) {
            MongoClientURI connectionString = new MongoClientURI(Constant.MONGODB_URL);
            MongoClient mongoClient = new MongoClient(connectionString);
            MongoDatabase database = mongoClient.getDatabase(Constant.DB_NAME);
            mongoCollection = database.getCollection("data");
        }
    }
    public List<DataPoint> findByName(String name) {
        List<DataPoint> result = new ArrayList<DataPoint>();
        FindIterable<Document> documents = mongoCollection.find(Filters.eq("name", name));
                                            //.sort(new Document().append("timeStamp", 1));
        for(Document document : documents) {
            String jsonString = document.toJson();
            DataPoint dataPoint = null;
            try {
                dataPoint = jacksonObjectMapper.readValue(jsonString, DataPoint.class);
                result.add(dataPoint);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public List<DataPoint> findAbnormalByName(String name) {
        List<DataPoint> result = new ArrayList<DataPoint>();
        Bson abnormalTemp = Filters.gt("temperature", 37);
        Bson abnormalHeart = Filters.or(Filters.lt("heartrate", 60), Filters.gt("heartrate", 100));
        Bson abnormalBlood = Filters.or(Filters.lt("bloodpressure", 80), Filters.gt("bloodpressure", 120));
        Bson abnormal = Filters.or(abnormalBlood, abnormalHeart, abnormalTemp);
        FindIterable<Document> documents = mongoCollection.find(Filters.and(Filters.eq("name", name), abnormal))
                .sort(new Document().append("timeStamp", 1));
        for(Document document : documents) {
            String jsonString = document.toJson();
            DataPoint dataPoint = null;
            try {
                dataPoint = jacksonObjectMapper.readValue(jsonString, DataPoint.class);
                result.add(dataPoint);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean insert(DataPoint dataPoint) {
        try {
            String jsonInString = jacksonObjectMapper.writeValueAsString(dataPoint);
            Document doc = Document.parse(jsonInString);
            mongoCollection.insertOne(doc);
            return true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteByName(String name) {
        Document document = new Document();
        document.append("name", name);
        mongoCollection.deleteMany(document);
        return true;
    }

    public int getDatasize() {
        return (int) mongoCollection.count();
    }

    public int getDatasize(String name) {
        Document document = new Document();
        document.append("name", name);
        return (int) mongoCollection.count(document);
    }
}
