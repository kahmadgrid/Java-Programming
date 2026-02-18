package week_3;
import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private String address;
    private double salary;

    public Employee(int id, String name, String address, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    // hashCode 
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // equals 
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Employee emp = (Employee) obj;

        return id == emp.id;
    }


    @Override
    public String toString() {
        return id + " " + name + " " + address + " " + salary;
    }

}
