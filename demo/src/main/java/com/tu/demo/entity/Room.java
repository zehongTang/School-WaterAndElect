package com.tu.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@TableName("dormitory")
public class Room implements Serializable {
    @TableId
    @TableField("room_ID")
    private String roomId;
    @TableField(" least_money")
    private Float leastMoney;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Float getLeastMoney() {
        return leastMoney;
    }

    public void setLeastMoney(Float leastMoney) {
        this.leastMoney = leastMoney;
    }
}
