package com.tu.demo.entity.VO;

import lombok.Data;


public class RallVo {
    private String  date;
    private Float waterConsumption;//水的用量
    private Float waterPrice;//水的单价
    private Float PerPrice;
    private Float Consumption;
    private Float totalPrice;//用水月账单金额
    private Float eotalPrice;//用电月账单金额

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getWaterConsumption() {
        return waterConsumption;
    }

    public void setWaterConsumption(Float waterConsumption) {
        this.waterConsumption = waterConsumption;
    }

    public Float getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(Float waterPrice) {
        this.waterPrice = waterPrice;
    }

    public Float getPerPrice() {
        return PerPrice;
    }

    public void setPerPrice(Float perPrice) {
        PerPrice = perPrice;
    }

    public Float getConsumption() {
        return Consumption;
    }

    public void setConsumption(Float consumption) {
        Consumption = consumption;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Float getEotalPrice() {
        return eotalPrice;
    }

    public void setEotalPrice(Float eotalPrice) {
        this.eotalPrice = eotalPrice;
    }
}
