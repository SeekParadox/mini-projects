package miniprojects.schooldb;

import java.time.LocalDate;
import java.util.Random;
import java.util.TreeSet;

public class Student extends Person{
    Course [] courses;
    private static final TreeSet<Integer> ids = new TreeSet<>(); //sorts data automatically
    private final int id = createId();
    public Student(String name, LocalDate dob) {
        super(name,dob);
    }

    private int createId(){
        Random random = new Random();
        while(true) {
            int numb = random.nextInt(9_000_000) + 1_000_000;
            if(!ids.contains(numb)) {
                ids.add(numb);
                // System.out.println(numb);
                return numb;
            }
        }
    }

    @Override
    public int compareTo(Person o) {
        if(o instanceof Student that )
            return this.id - that.id;
        return  -1;
    }

}
