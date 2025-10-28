public class Abstraction {
    public static void main(String[] args) {
        Horse h = new Horse();
        h.eat();
        h.walk();
        System.out.println(h.color);
        Chicken c = new Chicken();
        c.eat();
        c.walk();
    }
}

abstract class Animal{
    String color;
    void eat(){
        System.out.println("animal eats");
    }
    abstract void walk();
    Animal(){
        color ="brown";
    }
}

class Horse extends Animal{
    Horse(){
        System.out.println("Horse constructor called...");
    }
    void walk(){
        System.out.println("Walks on 4 legs");
    }
    void changeColor(){
        color = "dark brown";
    }
}

class Chicken extends Animal{
    Chicken(){
        System.out.println("Chicken constructor is called...");
    }
    void walk(){
      System.out.println("walks on 2 legs");
    }
    void changeColor(){
        color = "yellow";
    }
}