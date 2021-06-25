package com.fju;

import javax.swing.*;

public class Washer extends JFrame {
    int price;
    int minute;

    public Washer(){
        setSize(600,400);
        setLocation(300,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public Washer(int price,int minute) {
        this.price = price;
        this.minute = minute;
    }
}
