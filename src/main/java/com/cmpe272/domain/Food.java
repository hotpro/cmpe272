package com.cmpe272.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by yutao on 12/2/15.
 */
public class Food {
    @JsonProperty("RowID")
    private int rowID;

    @JsonProperty("ProductName")
    private String productName;

    @JsonProperty("ExpirationDate")
    private String expirationDate;

    @JsonProperty("Discount")
    private double discount;

    private String discountMsg;

    public String getDiscountMsg() {
        return discountMsg;
    }

    public void setDiscountMsg(String discountMsg) {
        this.discountMsg = discountMsg;
    }

    public int getRowID() {
        return rowID;
    }

    public void setRowID(int rowID) {
        this.rowID = rowID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
