package gb.lesson6.animals;

import java.util.Random;

public class Cat extends Animal {

    int maxRunLength;

    Random random = new Random();

    public Cat(String name) {
        super(name);
        maxRunLength = 50 * random.nextInt(10 + 1);

    }

    @Override
    public void run(int runLength) {
        if (runLength <= maxRunLength) {
            System.out.println("Cat " + name + " runs " + runLength + " meters");
        } else {
            System.out.println("Cat " + name + " can't run this distance (" + runLength + " maters)");
        }
    }

    @Override
    public void swim(int swimLength) {
        System.out.println("Cats can't swim=(");
    }
}
