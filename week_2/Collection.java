package week_2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Student{
    int age;
    String name;
    Student(int age, String name){
        this.age = age;
        this.name = name;
    }
    public String toString(){
        return ("Student [age = " + age + " name = " + name + "]");
    }
}
public class Collection {
    public static void main(String []args){
        Comparator<Student> comparator = (a, b) ->  a.age > b.age ? 1 : -1; // functional interface
        List<Student> nums = new ArrayList<Student>();
        nums.add(new Student(23,"Kamal"));
        nums.add(new Student(12, "Rohit"));
        nums.add(new Student(31, "Rahul"));
        nums.add(new Student(14, "Kiran"));
        nums.add(new Student(40, "Dyna"));

        Collections.sort(nums, comparator);
        for(Student a: nums){
            System.out.println(a);
        }

    }
}
