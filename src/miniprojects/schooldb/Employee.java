package miniprojects.schooldb;

import java.time.LocalDate;
import java.util.Random;
import java.util.TreeSet;


public class Employee extends Person {
    private static final TreeSet<Integer> ids = new TreeSet<>(); //sorts data automatically
    private final int id = createId();
    public Employee(String name, LocalDate dob) {
        super(name, dob);
    }

    private int createId(){
        Random random = new Random();
        while(true) {
           int numb = random.nextInt(200_000) + 100_000;
            if(!ids.contains(numb)) {
                ids.add(numb);
               // System.out.println(numb);
                return numb;
            }
        }
    }

    public static TreeSet<Integer> getIds() {
        return ids;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null ) return false;
        if(!(o instanceof Employee that )) return false;
        return this.id == that.id; // FIXME: 3/10/2022
    }

    @Override
    public int compareTo(Person o) {
        Employee e = (Employee) o;
        return this.id - e.id;
    }

    public static void main(String[] args) {
        Employee firstEmp = new Employee("Eren", LocalDate.of(1969,6,13));
        Employee secondEmp = new Employee("John", LocalDate.of(1969,2,14));
        Employee thirdEmp = new Employee("David", LocalDate.of(1953,5,5));
        System.out.println(getIds());

    }
}
