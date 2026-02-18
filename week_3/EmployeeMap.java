package week_3;
import java.util.HashMap;

public class EmployeeMap {

    private HashMap<Employee, String> map = new HashMap<>();


    // ADD
    public void addEmployee(Employee emp) {

        map.put(emp, emp.getName());

        System.out.println("Employee Added");

    }


    // UPDATE
    public void updateEmployee(Employee emp, String newAddress, double newSalary) {

        if(map.containsKey(emp)) {

            emp.setAddress(newAddress);

            emp.setSalary(newSalary);

            map.put(emp, emp.getName());

            System.out.println("Employee Updated");

        }
        else {

            System.out.println("Employee not found");

        }

    }


    // REMOVE
    public void removeEmployee(Employee emp) {

        map.remove(emp);

        System.out.println("Employee Removed");

    }


    // DISPLAY
    public void display() {

        map.forEach((k, v) ->

                System.out.println(k + " -> " + v)

        );

    }

}
