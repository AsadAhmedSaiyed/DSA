public class Inheritance {
    public static void main(String[] args) {
        // Fish shark = new Fish();
        // shark.eat();

        Dog dobby = new Dog();
        dobby.eat();
        dobby.legs=4;
        System.out.println(dobby.legs);
    }
}

//base class
class Animal{
    String color;
 
    void eat(){
        System.out.print("eats");
    }
    void breathe(){
        System.out.print("breathes");
    }
}

class Mammal extends Animal{
    int legs;
    void walk(){
        System.out.print("walk");
    }

}

class Dog extends Mammal{
    String breed;
}

//derived
class Fish extends Animal{
    int fins;
    void swim(){
       System.out.print("swims");
    }
}

class Bird extends Animal{

    void fly(){
       System.out.print("fly");
    }
}