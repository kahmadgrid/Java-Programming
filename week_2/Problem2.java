package week_2;
abstract class Animal{
    abstract void makeSound();
}
class Cat extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Cat sound meow...");
    }
}
class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Dog sound Barks..");
    }
}
public class Problem2 {
    public static void main(String args[]){
        Cat cat = new Cat();
        cat.makeSound();
        Dog dog = new Dog();
        dog.makeSound();
    }
}
