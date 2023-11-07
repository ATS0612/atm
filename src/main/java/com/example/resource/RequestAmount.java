package com.example.resource;

public class RequestAmount { // 入金額、出金額のリクエストをするBeanクラス

    private Integer amount; // HTMLのformのinput name = amonut とかの情報になるはず
    

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}