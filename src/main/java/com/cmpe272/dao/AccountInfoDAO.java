package com.cmpe272.dao;

import com.cmpe272.domain.AccountInfo;
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
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 */
@Component
public class AccountInfoDAO {
    static MongoCollection mongoCollection = null;
    static ObjectMapper jacksonObjectMapper;
    public AccountInfoDAO() {
        if(jacksonObjectMapper == null) {
            jacksonObjectMapper = new ObjectMapper();
            jacksonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
        if(mongoCollection == null) {
            MongoClientURI connectionString = new MongoClientURI(Constant.MONGODB_URL);
            MongoClient mongoClient = new MongoClient(connectionString);
            MongoDatabase database = mongoClient.getDatabase(Constant.DB_NAME);
            mongoCollection = database.getCollection("account");
        }
    }
    public List<String> getAllName() {
        List<String> result = new ArrayList<String>();
        FindIterable<Document> documents = mongoCollection.find();
        for(Document document : documents) {
            String jsonString = document.toJson();
            AccountInfo accountInfo = null;
            try {
                accountInfo = jacksonObjectMapper.readValue(jsonString, AccountInfo.class);
                result.add(accountInfo.getUsername());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public List<AccountInfo> findAll(){
    	List<AccountInfo> result = new ArrayList<AccountInfo>();
        FindIterable<Document> documents = mongoCollection.find();
        for(Document document : documents) {
            String jsonString = document.toJson();
            AccountInfo accountInfo = null;
            try {
                accountInfo = jacksonObjectMapper.readValue(jsonString, AccountInfo.class);
                result.add(accountInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public AccountInfo getAccountInfo(String name) {
        Document document = (Document) mongoCollection.find(Filters.eq("username", name)).first();
        if(document == null) return null;
        String jsonString = document.toJson();
        AccountInfo accountInfo = null;
        try {
            accountInfo = jacksonObjectMapper.readValue(jsonString, AccountInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountInfo;
    }

    public boolean insert(AccountInfo accountInfo) {
        if(getAccountInfo(accountInfo.getUsername()) != null) {
            return false; //already exist
        }
        try {
            String jsonInString = jacksonObjectMapper.writeValueAsString(accountInfo);
            Document doc = Document.parse(jsonInString);
            mongoCollection.insertOne(doc);
            return true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public AccountInfo findById(String id){
        if(id==null){
            return null;
        }
        Document document = (Document) mongoCollection.find(new Document("id",id)).first();
        AccountInfo accountInfo = null;
        try {
            accountInfo = jacksonObjectMapper.readValue(document.toJson(), AccountInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountInfo;
    }

    public void deleteById(String id) {
        Document document = (Document) mongoCollection.find(Filters.eq("id", id)).first();
        if(document!=null){
            mongoCollection.deleteMany(document);
        }
    }
}
