package Lesson_6;

import Lesson_6.Animals.Cat;
import Lesson_6.Animals.Dog;

public class MainClass {
    public static void main (String[] args){
        Cat cat1 = new Cat("Оливер", 8);
        Dog dog1 = new Dog("Симба", 2);
        Cat cat2 = new Cat("Ася", 15);
        Dog dog2 = new Dog("Филя", 13);
        cat1.info();
        cat2.info();
        dog1.info();
        dog2.info();
        System.out.println();

        dog1.run(400);
        dog1.run(100);
        cat1.run(200);
        cat1.run(100);
        cat1.run(50);
        cat1.run(200);
        cat1.run(400);
        cat1.run(50);
        dog1.jump(0.3);
        dog2.swim(4.3);
        cat2.swim(5);
        cat1.swim(2);
        cat1.sleep(4);
        cat1.run(200);
    }
}
