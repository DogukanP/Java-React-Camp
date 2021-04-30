package com.padel;

public class Student extends User{
    private String cardInfo;
    private String address;
    private String[] lessons;

    public Student(int id, String firstName, String lastName, String imageURl, String email, String cardInfo, String address, String[] lessons) {
        super(id, firstName, lastName, imageURl, email);
        this.cardInfo = cardInfo;
        this.address = address;
        this.lessons = lessons;
    }


    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getLessons() {
        return lessons;
    }

    public void setLessons(String[] lessons) {
        this.lessons = lessons;
    }
}
