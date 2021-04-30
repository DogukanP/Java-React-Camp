package com.padel;

public class InstructorManager {
    public void editBio(Instructor instructor,String bio){
        instructor.setBio(bio);
        System.out.println("Biyografi değiştirildi.");
    }

    public void addVideo(Instructor instructor){
        System.out.println(instructor.getCourses()[1] + " kursuna video başarıyla eklendi");
    }
}
