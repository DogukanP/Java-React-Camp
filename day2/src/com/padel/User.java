package com.padel;

public class User {
    public User(){
        System.out.println("YAPICI ÇALIŞTI");
    }

    public User(int id,String imageURL,String name,String cardInfo, String contact){
        this.id = id;
        this.imageURL = imageURL;
        this.name = name;
        this.cardInfo = cardInfo;
        this.contact = contact;
    }

    int id;
    String imageURL;
    String name;
    String cardInfo;
    String contact;

}
