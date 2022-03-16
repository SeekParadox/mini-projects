package miniprojects.schooldb;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Person implements Comparable<Person>  {
    private String name;
    private int age;
    private LocalDate dob;

    public Person() {

    }

    Person(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;

    }


    public void setAge(int name) {

    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOldEnough () {
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        return dob.isBefore(date);

    }

    public void setDob(LocalDate dob) {
        this.dob = isOldEnough() ?  dob : null;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }


    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(!(o instanceof Person that)) return false;
        return Objects.equals(this.name,that.name) && Objects.equals(this.dob,that.dob);
    }


    public abstract int compareTo(Person o);
}
