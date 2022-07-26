package gb.lesson6.animals;

import java.util.Random;

public class Dog extends Animal {

    Random random = new Random();
    int maxRunLength;
    int maxSwimLength;

    public Dog(String name) {
        super(name);
        maxRunLength = 100 * random.nextInt(10 + 1);
        maxSwimLength = 10 * random.nextInt(10 + 1);
    }


    @Override
    public void run(int runLength) {
        if (runLength <= maxRunLength) {
            System.out.println("Dog " + name + " runs " + runLength + " meters");
        } else {
            System.out.println("Dog " + name + " can't run this distance (" + runLength + " maters)");
        }
    }

    @Override
    public void swim(int swimLength) {
        if (swimLength <= maxSwimLength) {
            System.out.println("Dog " + name + " swims " + swimLength + " meters");
        } else {
            System.out.println("Dog " + name + " can't swim this distance (" + swimLength + " maters)");
        }
    }
}
