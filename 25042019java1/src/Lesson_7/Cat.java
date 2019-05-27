package Lesson_7;

import java.util.Random;

public class Cat {
    Random rand = new Random();
    private String name;
    private int eating;
    private boolean satiety;

    public Cat(String name) {
        this.name = name;
        this.eating = rand.nextInt(10) + 10;
        this.satiety = false;
    }

    @Override
    public String toString() {
        return "Кот " + "" + name + ", кушает " + eating + ", сытость = " + satiety ;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= eating) {
            plate.decreaseFood(eating);
            satiety = true;
            System.out.println(name + " покушал");
        } else {
            System.out.print(name + " не хватило еды.");
            plate.setFood(100);
            System.out.println(" Тарелка с едой пополнена");
        }
    }

    public void satietyCheck() {
        if (satiety == true) System.out.println(name + " сыт (сытость = "+ satiety + ")");
        else System.out.println(name + " голоден (сытость = "+ satiety +")");
    }
}
