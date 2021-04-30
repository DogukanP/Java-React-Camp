package com.padel;

public class Instructor extends User{
    private String bio;
    private String[] courses;


    public Instructor(int id, String firstName, String lastName, String imageURl, String email, String bio, String[] courses) {
        super(id, firstName, lastName, imageURl, email);
        this.bio = bio;
        this.courses = courses;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }
}
