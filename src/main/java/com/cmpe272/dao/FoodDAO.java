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
import com.mongodb.client.result.UpdateResult;
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
            try {
                list.add(FoodDAO.parseFood(document));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private static final SimpleDateFormat PARSE_FORMAT = new SimpleDateFormat("MM/dd/yy");
    public void changeDate() {
        FindIterable<Document> iterable = mongoCollection.find();
        for (Document document : iterable) {
            String s = document.getString("ExpirationDate");
            int rowID = document.getInteger("RowID");
            Date date = null;
            try {
                date = PARSE_FORMAT.parse(s);
                mongoCollection.updateOne(new Document("RowID", rowID),
                        new Document("$set", new Document("Date", date)));
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

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    public static Food parseFood(Document document) throws Exception {
        Food food = new Food();
        Object object = document.get("Discount");
        double discount = 0;
        if (object instanceof Double) {
            discount = document.getDouble("Discount");
        } else if (object instanceof Integer) {
            discount = document.getInteger("Discount").intValue();
        }
        food.setDiscount(discount);
        Date date = document.getDate("Date");
        if (discount > 0) {
            String discountMsg = (int)(discount * 100) + " % OFF";
            food.setDiscountMsg(discountMsg);
        } else if (discount < 0) {
            food.setDiscountMsg("Donated");
        } else {
            food.setDiscountMsg("");
        }
        food.setExpirationDate(FORMAT.format(date));
        food.setProductName(document.getString("ProductName"));
        food.setRowID(document.getInteger("RowID"));
        return food;
    }

    public boolean setFoodDiscount(Date start, Date end, double discount) {
        BasicDBObject query = new BasicDBObject();
        query.put("Date", BasicDBObjectBuilder.start("$gte", start).add("$lte", end).get());
        UpdateResult result = mongoCollection.updateMany(query, new Document("$set",
                new Document("Discount", discount)));
        return result.wasAcknowledged();
    }

}
