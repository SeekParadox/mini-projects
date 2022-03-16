package miniprojects.schooldb;

import java.time.LocalDate;
import java.util.*;

public class Instructor extends Employee {
    private Department department;
    private Course [] courses;
    private Course course;
    private int current = 0;
    public Instructor(String name, LocalDate dob) {
        super(name, dob);
        courses = new Course[10];
    }

    public Instructor(String name, LocalDate dob, Department department /*, Course[] courses*/) {
        this(name, dob);
        this.department = department;
        //this.courses = courses;

    }

    public void addCourse(Course course) {
        if(current < courses.length) {
            courses[current++] = course;

            if (course.isHasTeacher() && course.getInstructor() != this)
                course.removeInstructor();
            course.setInstructor(this);
        }
        else
            System.out.println("Maximum courses reached");

    }

    public int numOfCourseTaught() {
        int i = 0;
        for(Course current : courses)
            if(current != null)
                i++;
        return i;
    }

    public Course[] getCourses() {
        if(current == 0) throw new NullPointerException("Array is empty");
        Course [] temp = new Course[current];
        System.arraycopy(courses, 0, temp, 0, current - 1 + 1);
        return temp ;
    }

    public Course getCourse(int index) {
        if(index >= 0 && index < current)
        return courses[index];
        return null;

    }

    public void removeCourse(Course course) {
        //implement binarySearch on course later
        //note: insert course sorted

        if(current > 0) {
            int size = courses.length;
            for (int i = 0; i < size; i++) {
                if (courses[i] == course) {
                    for (int j = i; j < size - 1; j++) {
                        courses[j] = courses[j + 1];
                    }
                }
            }
            if(course.isHasTeacher())
            course.removeInstructor(this);
            courses[size-1] = null;
            current--;
        }
        //Arrays.binarySearch(courses,course);
    }

    public boolean hasCourse(Course course) {
        for(Course c : courses)
            if(c == course)
                return true;
        return false;

    }

    public int getCurrent() {
        return current;
    }

    @Override
    public String toString() {
        return String.format("%s",getName());
//         "Instructor{" +
//                "department=" + department +
//                ", courses=" + Arrays.toString(courses) +
//                ", course=" + course +
//                ", current=" + current +
//                '}';
    }
}
