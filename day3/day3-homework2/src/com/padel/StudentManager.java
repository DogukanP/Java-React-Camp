package com.padel;

public class StudentManager {
    public void login(Student student) {
        System.out.println("Hoşgeldin " + student.getFirstName());
    }

    public void addAdress(Student student,String address){
        System.out.println(student.getAddress());
        student.setAddress(address);
        System.out.println("Adres başarıyla eklendi.");
        System.out.println(student.getAddress());
    }
}
