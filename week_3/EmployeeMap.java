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


public static void main(String[] args) {

        EmployeeMap empMap = new EmployeeMap();

        Employee emp1 = new Employee(0, "Alice", "123 Main St", 50000);
        Employee emp2 = new Employee(1, "Bob", "456 Elm St", 60000);

        empMap.addEmployee(emp1);
        empMap.addEmployee(emp2);

        empMap.display();

        empMap.updateEmployee(emp1, "789 Oak St", 55000);

        empMap.display();

        empMap.removeEmployee(emp2);

        empMap.display();

    }
}