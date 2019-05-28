package Lesson_6.Animals;

public class Animal {
    String name;
    int age;
    double dist, high, swimDist, energy, energyDefault;

    public Animal(String name, int age, double maxDist, double maxHigh, double maxSwimDist, double maxEnergy) {
        this.name = name;
        this.age = age;
        if (age > 0 && age <= 8) {
            dist = maxDist * (double) age / 6;
            high = maxHigh * (double) age / 6;
            swimDist = maxSwimDist * (double) age / 6;
            energy = maxEnergy * (double) age / 6;
        } else {
            dist = maxDist * (double) (20 - age) / 10;
            high = maxHigh * (double) (20 - age) / 10;
            swimDist = maxSwimDist * (double) (20 - age) / 10;
            energy = maxEnergy * (double) (20 - age) / 10;
        }
        energyDefault = energy;
    }

    public Animal(String name, int age, double maxDist, double maxHigh, double maxEnergy) {
        this.name = name;
        this.age = age;
        if (age > 0 && age <= 8) {
            dist = maxDist * (double) age / 6;
            high = maxHigh * (double) age / 6;
            energy = maxEnergy * (double) age / 6;
        } else {
            dist = maxDist * (double) (20 - age) / 10;
            high = maxHigh * (double) (20 - age) / 10;
            energy = maxEnergy * (double) (20 - age) / 10;
        }
        energyDefault = energy;
    }

    public void info() {
        if (age >= 5)
            System.out.printf("%s, %d лет. Максимальная дистанция бега: %.2f метров. Максимальная высота прыжка: %.2f метров. Плавает на %.2f метров.\n", name, age, dist, high, swimDist);
        if (age >= 2 && age < 5)
            System.out.printf("%s, %d года. Максимальная дистанция бега: %.2f метров. Максимальная высота прыжка: %.2f метров. Плавает на %.2f метров.\n", name, age, dist, high, swimDist);
        if (age == 1)
            System.out.printf("%s, %d года. Максимальная дистанция бега: %.2f метров. Максимальная высота прыжка: %.2f метров. Плавает на %.2f метров.\n", name, age, dist, high, swimDist);
    }

    public void run(int distance) {
        if (energy > 0) {
            if (distance <= dist) {
                energy -= distance;
                System.out.printf("%s успешно пробежал %d метров\n", name, distance, energy);
            } else {
                if ((energy - dist) > 0) {
                    energy -= dist;
                    System.out.printf("%s не смог пробежать %d метров. %s пробежал %.2f метров и устал...\n", name, distance, name, dist);
                } else {
                    System.out.printf("%s не смог пробежать %d метров. %s пробежал %.2f метров и устал...\n", name, distance, name, energy);
                    energy = 0;
                }
            }
        } else System.out.printf("%s больше не может бежать. Не осталось энергии. Нужно дать отдохнуть\n", name);
    }

    public void jump(double higness) {
        if (energy > 0) {
            if (higness <= high) {
                energy = energy - higness * 10;
                System.out.printf("%s успешно запрыгнуть на высоту в %.2f метров\n", name, higness);
            } else {
                if ((energy - high * 10) > 0) {
                    energy = energy - high * 10;
                    System.out.printf("%s не смог запрыгнуть на высоту в %.2f метров...\n", name, higness);
                } else {
                    System.out.printf("%s не смог запрыгнуть на высоту в %.2f метров...\n", name, higness);
                    energy = 0;
                }
            }
        } else System.out.printf("%s больше не может прыгать. Не осталось энергии.. Нужно дать отдохнуть\n", name);
    }

    public void swim(double swimDistance) {
        if (energy > 0) {
            if (swimDistance <= swimDist) {
                energy = energy - swimDistance * 20;
                System.out.printf("%s успешно проплыл %.2f метров\n", name, swimDistance);
            } else System.out.printf("%s не может проплыть %.2f метров...\n", name, swimDistance);


        } else System.out.printf("%s больше не может плыть. Не осталось энергии. Нужно дать отдохнуть\n", name);
    }

    public void sleep(int time) {
        energy = energy + time * 100;
        if (energy >= energyDefault) {
            energy = energyDefault;
            System.out.println(name + " полностью отдохнул");
        } else System.out.println(name + " хорошо отдохнул");
    }
}
