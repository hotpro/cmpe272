package com.cmpe272.dao;

import com.cmpe272.domain.DiscountNum;
import com.cmpe272.domain.DiscountStat;
import com.cmpe272.domain.Food;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        double discount = getDiscount(document, "Discount");
        food.setDiscount(discount);
        Date date = document.getDate("Date");
        food.setDiscountMsg(getDiscountMsg(discount));
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

    public long getDonationCount(Date start, Date end) {
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("Date", BasicDBObjectBuilder.start("$gte", start).add("$lte", end).get());
//        basicDBObject.put("Discount", new Document("$lt", 0));
        return mongoCollection.count(basicDBObject);
    }

    public List<DiscountNum> getTop5Discount() {
        AggregateIterable<Document> iterable = mongoCollection.aggregate(Arrays.asList(
                new Document("$group", new Document("_id", "$Discount").append("count", new Document("$sum", 1)))
                ,
                new Document("$sort", new Document("count", -1)),
                new Document("$limit", 5)
                ));
        List<DiscountNum> list = new ArrayList<>();
        for (Document document : iterable) {
            System.out.println(document);
            DiscountNum discountNum = new DiscountNum();
            discountNum.disCountMsg = getDiscountMsg(getDiscount(document, "_id"));
            discountNum.count = document.getInteger("count");
            list.add(discountNum);
        }
        return list;
    }

    private static double getDiscount(Document document, String key) {
        double discount = 0;
        Object object = document.get(key);
        if (object instanceof Double) {
            discount = document.getDouble(key);
        } else if (object instanceof Integer) {
            discount = document.getInteger(key).intValue();
        }
        return discount;
    }

    private static String getDiscountMsg(double discount) {
        String discountMsg = "";
        if (discount > 0) {
            discountMsg = (int)(discount * 100) + " % OFF";
        } else if (discount < 0) {
            discountMsg = "Donated";
        }
        return discountMsg;
    }

    public List<DiscountStat> getDiscountStat() {
        int[] nums = {2015, 2016, 2017, 2018, 2019};
        double[] discounts = {0.1, 0.5, -1};
        List<DiscountStat> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            DiscountStat discountStat = new DiscountStat();
            discountStat.year = String.valueOf(nums[i]);
            discountStat.off10 = getDiscountByYear(nums[i], 0.1);
            discountStat.off50 = getDiscountByYear(nums[i], 0.5);
            discountStat.donation = getDiscountByYear(nums[i], -1);
            list.add(discountStat);
        }
        return list;
    }

    private long getDiscountByYear(int year, double discount) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date start = cal.getTime();
        cal.add(Calendar.YEAR, 1);
        Date end = cal.getTime();
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("Date", BasicDBObjectBuilder.start("$gte", start).add("$lte", end).get());
        if (discount > 0) {
            basicDBObject.put("Discount", discount);
        } else {
            basicDBObject.put("Discount", new Document("$lt", 0));
        }
        return mongoCollection.count(basicDBObject);
    }

}
