package com.padel;

public class Main {

    public static void main(String[] args) {
        Student dogukan = new Student(1,"Doğukan","Padel","image","d.padel@outlook.com","123456789","Türkiye",new String[] { "Java", "C#" });
        Instructor engin = new Instructor(2,"Engin","Demiroğ","image","engin@mail.com","MCT,PMP...", new String[] { "Java", "C#" ,"Pyhton"});

        InstructorManager instructorManager = new InstructorManager();
        instructorManager.addVideo(engin);
        instructorManager.editBio(engin,"ODTÜ");

        StudentManager studentManager = new StudentManager();
        studentManager.login(dogukan);
        studentManager.addAdress(dogukan,"İngiltere");
    }
}
