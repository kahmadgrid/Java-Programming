package week_2;

class Engine{
    private String type;
    Engine(String type){
        this.type = type;
    }

    void EngineStart(){
        System.out.println(type + " engine Started...");
    }
    void EngineStop(){
        System.out.println(type + " engine Stoped..!");
    }
}
class Car{
    private Engine engine;
    Car(Engine engine){
        this.engine = engine;
    }

    void CarStart(){
        System.out.println("Car is starting..");
        engine.EngineStart();
    }
    void CarStop(){
        System.out.println("Car is Stopping..");
        engine.EngineStop();
    }
}
public class Main {
    public static void main(String args[]){
        Engine petrolEngine = new Engine("Petrol");
        Car maruti = new Car(petrolEngine);

        maruti.CarStart();
        maruti.CarStop();

      
    }
}
