package com.padel;

public class CourseManager {
    public void addCourse(Course course) {
        System.out.println(course.name +" 'na katılım sağlandı.");
    }

    public void deleteCourse(Course course) {
        System.out.println(course.name +" 'ndan çıktınız");
    }
}
