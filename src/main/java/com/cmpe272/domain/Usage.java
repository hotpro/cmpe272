package com.cmpe272.domain;

/**
 */
public class Usage {
    public Usage() {};
    public Usage(int count, int credit) {
        this.dataCount = count;
        this.credit = credit;
        this.balance = credit - count;
    }

    int dataCount;
    int credit;
    int balance;
    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }


}
