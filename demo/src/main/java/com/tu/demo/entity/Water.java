package com.tu.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.io.Serializable;


@TableName("water")
public class Water implements Serializable {
    @TableId(type = IdType.INPUT)
    private String  date;
    @TableField("water_consumption")
    private Float waterConsumption;//水的用量
    @TableField("water_per_price")
    private Float waterPrice;//水的单价
    @TableField("total_price")
    private Float totalPrice;//用水月账单金额

    public Water() {
    }

    public Water(String date, Float waterConsumption, Float waterPrice, Float totalPrice) {
        this.date = date;
        this.waterConsumption = waterConsumption;
        this.waterPrice = waterPrice;
        this.totalPrice = totalPrice;
    }

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

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
