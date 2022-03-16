package miniprojects.schooldb;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Instructor me = new Instructor("Josh", LocalDate.of(1994,3,20), new Department());
        Course c1 = new Course("CMP 149",3);
        Course c2 = new Course("CMP 334",3);
        Course c3 = new Course("CMP 339",3);
        Course c4 = new Course("CMP 232",3);

//        me.addCourse(c1);
//        me.addCourse(c2);
//        me.addCourse(c3);
//        me.addCourse(c4);
//        Course [] firstPass =  me.getCourses();
//        for(Course c : firstPass)
//            System.out.print(c.getName() + " ");
//        System.out.println("");
//        System.out.println(me.getCourse(0).getInstructor().getName());
//        System.out.println(c1.getInstructor());
//        me.removeCourse(c1);
//        System.out.println(c1.getInstructor());
        c1.setInstructor(me);
        System.out.println(me.getCourse(0).getName());
//      Course [] secondPass = me.getCourses();
//        for(Course c : secondPass) {
//            System.out.print(c.getName() + " ");
//        }
//        System.out.println("");
//        me.removeCourse(c1);
//        Course [] thirdPass = me.getCourses();
//        for(Course c : thirdPass)
//            System.out.print(c.getName() + " ");
//        System.out.println("");
//
//        me.removeCourse(c3);
//        Course [] fourthPass = me.getCourses();
//        for(Course c : fourthPass)
//            System.out.print(c.getName() + " ");
//        System.out.println("");
    }
}
