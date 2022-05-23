package com.paydemo1.demo.pojo;



public class Pocket {

    private String room_ID;
    private String balance;
    private String recharge;

    public String getRoom_ID() {
        return room_ID;
    }

    public void setRoom_ID(String room_ID) {
        this.room_ID = room_ID;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getRecharge() {
        return recharge;
    }

    public Pocket(String room_ID, String balance, String recharge) {
        this.room_ID = room_ID;
        this.balance = balance;
        this.recharge = recharge;
    }

    @Override
    public String toString() {
        return "Pocket{" +
                "room_ID='" + room_ID + '\'' +
                ", balance='" + balance + '\'' +
                ", recharge='" + recharge + '\'' +
                '}';
    }

    public void setRecharge(String recharge) {
        this.recharge = recharge;
    }
}
