package com.cmpe272.domain;

import org.bson.types.ObjectId;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 */
public class DataPoint {

    private String id = new ObjectId().toString();

    private String name;

    @JsonProperty("$numberLong")
    private long timeStamp;

    private double temperature;

    private double bloodpressure;

    private int heartrate;

    private String sensorId;

    private String sensorOwnerId;

    public DataPoint() {

    }

    public DataPoint(String name, long timeStamp, double temperature, double bloodpressure, int heartrate, String sensorId, String sensorOwnerId) {
        this.name = name;
        this.timeStamp = timeStamp;
        this.temperature = temperature;
        this.bloodpressure = bloodpressure;
        this.heartrate = heartrate;
        this.sensorId = sensorId;
        this.sensorOwnerId = sensorOwnerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getBloodpressure() {
        return bloodpressure;
    }

    public void setBloodpressure(double bloodpressure) {
        this.bloodpressure = bloodpressure;
    }

    public int getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(int heartrate) {
        this.heartrate = heartrate;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorOwnerId() {
        return sensorOwnerId;
    }

    public void setSensorOwnerId(String sensorOwnerId) {
        this.sensorOwnerId = sensorOwnerId;
    }
}
