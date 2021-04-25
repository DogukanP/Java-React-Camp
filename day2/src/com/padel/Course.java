package com.padel;

public class Course {
    public Course(){
        System.out.println("YAPICI ÇALIŞTI");
    }

    public Course (int id,String imageURL,String name,String explanation, String instructorName){
        this.id = id;
        this.imageURL = imageURL;
        this.name = name;
        this.explanation = explanation;
        this.instructorName = instructorName;
    }

    int id;
    String imageURL;
    String name;
    String explanation;
    String instructorName;
}
