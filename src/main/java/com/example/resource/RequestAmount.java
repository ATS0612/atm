package com.example.resource;

public class RequestAmount { // 入金額、出金額のリクエストと残高をレスポンスするときに利用するBeanクラス

    private Integer amount;

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}