package miniprojects.schooldb;

import java.util.Objects;

public class Course implements Comparable<Course>{
    private String name;
    private int numOfCredits;
    private boolean hasTeacher = false;
    private Instructor instructor;

    public Course(String name, int numOfCredits) {
        this.name = name;
        this.numOfCredits = numOfCredits;
    }

    public Course(String name, int numOfCredits, Instructor instructor) {
        this(name,numOfCredits);
        this.instructor = instructor;
        hasTeacher = true;
    }

    public void setInstructor(Instructor instructor) {
        if(!hasTeacher) {
            this.instructor = instructor;
            hasTeacher = true;
            if(instructor.getCurrent() > 0) {
                boolean hasCourse = instructor.hasCourse(this);
                if(!hasCourse)
                    instructor.addCourse(this);
            } else
                instructor.addCourse(this);
        }
    }
    public void removeInstructor() {
        hasTeacher = false;
        instructor.removeCourse(this);


        instructor = null;

    }
    public void removeInstructor(Instructor instructor) {
        if(hasTeacher) {
            for (Course c : instructor.getCourses())
                if(c == this)
            instructor.removeCourse(this);
        }
        hasTeacher = false;
        this.instructor = null;

    }

    public Instructor getInstructor() {
        return instructor;
    }

    public String getName() {
        return name;
    }

    public boolean isHasTeacher() {
        return hasTeacher;
    }

    @Override
    public int compareTo(Course o) {
        return this.name.compareTo(o.name);
    }
}
