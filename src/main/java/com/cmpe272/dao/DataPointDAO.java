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
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaofengli on 11/30/15.
 */
@Component
public class DataPointDAO {

    static MongoCollection mongoCollection = null;

    static ObjectMapper jacksonObjectMapper;

    public DataPointDAO() {
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

    public void add(DataPoint dataPoint){
        try {
            String jsonInString = jacksonObjectMapper.writeValueAsString(dataPoint);
            Document doc = Document.parse(jsonInString);
            mongoCollection.insertOne(doc);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(String id){
        Document document = (Document) mongoCollection.find(Filters.eq("id", id)).first();
        if(document!=null){
            mongoCollection.deleteMany(document);
        }
    }

    public List<DataPoint> findAllBySensorId(String sensorId){
        List<DataPoint> list = new ArrayList<DataPoint>();
        FindIterable<Document> iterable = this.mongoCollection.find(new Document("sensorId",sensorId));
        for(Document document : iterable) {
            String jsonString = document.toJson();
            DataPoint data = null;
            try {
                data = jacksonObjectMapper.readValue(jsonString, DataPoint.class);
                list.add(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Collections.reverse(list);
        return list;
    }

    public List<DataPoint> findAllBySensorOwnerId(String sensorOwnerId){
        List<DataPoint> list = new ArrayList<DataPoint>();
        FindIterable<Document> iterable = this.mongoCollection.find(new Document("sensorOwnerId",sensorOwnerId));
        for(Document document : iterable) {
            String jsonString = document.toJson();
            DataPoint data = null;
            try {
                data = jacksonObjectMapper.readValue(jsonString, DataPoint.class);
                list.add(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Collections.reverse(list);
        return list;
    }

    public DataPoint findById(String id){
        if(id==null){
            return null;
        }
        Document document = (Document) mongoCollection.find(new Document("id",id)).first();
        DataPoint data = null;
        try {
            data = jacksonObjectMapper.readValue(document.toJson(), DataPoint.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public List<DataPoint> findAbnormalBySensorId(String sensorId) {
        List<DataPoint> result = new ArrayList<DataPoint>();
        Bson abnormalTemp = Filters.gt("temperature", 37);
        Bson abnormalHeart = Filters.or(Filters.lt("heartrate", 60), Filters.gt("heartrate", 100));
        Bson abnormalBlood = Filters.or(Filters.lt("bloodpressure", 80), Filters.gt("bloodpressure", 120));
        Bson abnormal = Filters.or(abnormalBlood, abnormalHeart, abnormalTemp);
        FindIterable<Document> documents = mongoCollection.find(Filters.and(Filters.eq("sensorId", sensorId), abnormal))
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
        Collections.reverse(result);
        return result;
    }

    public int getDatasize() {
        return (int) mongoCollection.count();
    }

    public int getDatasizeBySensorOwnerId(String id) {
        Document document = new Document();
        document.append("sensorOwnerId", id);
        return (int) mongoCollection.count(document);
    }

}
