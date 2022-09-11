package gb.lesson6;

import gb.lesson6.animals.Animal;
import gb.lesson6.animals.Cat;
import gb.lesson6.animals.Dog;

public class Main {
    static int counterAnimals = 0;
    static int counterDog = 0;
    static int counterCat = 0;

    public static void main(String[] args) {

        Dog dog1 = new Dog("REX");
        isInstance(dog1);
        dog1.run(550);

        Cat cat1 = new Cat("OLIVER");
        isInstance(cat1);
        cat1.run(250);

        Animal dog2 = new Dog("LESSIE");
        isInstance(dog2);
        dog2.swim(20);

        Animal cat2 = new Cat("POLLY");
        isInstance(cat2);
        cat2.swim(20);

        System.out.println("\nAnimals: " + counterAnimals + "\nCats: " + counterCat + "\nDogs: " + counterDog);
    }

    public static void isInstance(Animal animal) {
        if (animal instanceof Animal) {
            counterAnimals++;
        }
        if (animal instanceof Dog) {
            counterDog++;
        }
        if (animal instanceof Cat) {
            counterCat++;
        }
    }
}
