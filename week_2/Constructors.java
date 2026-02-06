package week_2;
class A {
    public A(){
        System.out.println("This is A");
    }
    public A(int n){
        System.out.println("this is A with " + n);
    }
}
class B extends A {
    public B(){
        System.out.println("This is B");
    }
    public B(int n){
        this();
        System.out.println("this is B with " + n);
    }
}
public class Constructors {
    public static void main(String []args){
        B obj = new B(5);
    }
    
}
