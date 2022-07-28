package gb.lesson7;

import java.util.Random;

public class Cat {

    Random random = new Random();
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name) {
        this.name = name;
        appetite = 5 + random.nextInt(15);
        fullness = false;
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {
            fullness = true;
            System.out.println("Cat " + name + " eat successfully " + appetite + " food");
        } else {
            System.out.println("Cat " + name + " can't eat " + appetite + " food. It's too low");
            fullness = false;
        }
    }

    public void info() {
        System.out.println("Cat " + name + " fullness is " + fullness);
    }
}
