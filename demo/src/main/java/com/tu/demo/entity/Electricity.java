package com.tu.demo.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@TableName("electricity")
public class Electricity implements Serializable {
    @TableId
    private String date;
    @TableField("electricity_per_price")
    private float PerPrice;
    @TableField("electricity_consumption")
    private float Consumption;
    @TableField("etotal_price")
    private float eTotalPrice;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPerPrice() {
        return PerPrice;
    }

    public void setPerPrice(float perPrice) {
        PerPrice = perPrice;
    }

    public float getConsumption() {
        return Consumption;
    }

    public void setConsumption(float consumption) {
        Consumption = consumption;
    }

    public float geteTotalPrice() {
        return eTotalPrice;
    }

    public void seteTotalPrice(float eTotalPrice) {
        this.eTotalPrice = eTotalPrice;
    }
}
