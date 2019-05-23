package Lesson_6.Animals;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age, 200, 2, 500);
    }

    @Override
    public void info() {

        if (age >= 5)
            System.out.printf("%s, %d лет. Максимальная дистанция бега: %.2f метров. Максимальная высота прыжка: %.2f метров. Плавать не умеет...\n", name, age, dist, high);
        if (age >= 2 && age < 5)
            System.out.printf("%s, %d года. Максимальная дистанция бега: %.2f метров. Максимальная высота прыжка: %.2f метров. Плавать не умеет...\n", name, age, dist, high);
        if (age == 1)
            System.out.printf("%s, %d года. Максимальная дистанция бега: %.2f метров. Максимальная высота прыжка: %.2f метров. Плавать не умеет...\n", name, age, dist, high);
    }

    @Override
    public void swim(double swimDistance) {
        System.out.println(name + " - кот. Коты не умеют плавать=(");
    }
}
