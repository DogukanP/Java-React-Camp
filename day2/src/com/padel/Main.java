package com.padel;

public class Main {

    public static void main(String[] args) {
        Course course1 = new Course(
                1,
                "image1",
                "Yazılım Geliştirici Yetiştirme Kampı(C# + Angular)",
                "2 ay sürecek Yazılım Geliştirici Yetiştirme Kampı...",
                "Engin Demirog"
        );

        Course course2 = new Course(
                2,
                "image2",
                "Yazılım Geliştirici Yetiştirme Kampı(JAVA + REACT)",
                "2 ay sürecek Yazılım Geliştirici Yetiştirme Kampı...",
                "Engin Demirog"
        );

        Course course3 = new Course(
                3,
                "image3",
                "Programlamaya Giriş İçin Temel Kurs",
                "PYTHON, JAVA; C# gibi tüm programlama dilleri için temel...",
                "Engin Demirog"
        );

        User user1 = new User(1,"imageUser","User1","XYZ Bank", "05365154878");
        User user2 = new User(2,"imageUser2","User2","XYZ Bank", "05384578621");

        Course[] courses = { course1, course2, course3 };
        User[] users = {user1,user2};

        for(Course course : courses){
            System.out.println(course.id);
            System.out.println(course.imageURL);
            System.out.println(course.name);
            System.out.println(course.explanation);
            System.out.println(course.instructorName);
            System.out.println("=================================================================");
            System.out.println(" ");
        }

        for(User user : users){
            System.out.println(user.id);
            System.out.println(user.imageURL);
            System.out.println(user.name);
            System.out.println(user.cardInfo);
            System.out.println(user.contact);
            System.out.println("=================================================================");
        }

        CourseManager courseManager = new CourseManager();
        UserManager userManager = new UserManager();
        courseManager.addCourse(course1);
        courseManager.deleteCourse(course1);
        userManager.logOut(user1);
    }
}
