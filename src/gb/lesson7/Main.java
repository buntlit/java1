package gb.lesson7;

public class Main {
    public static void main(String[] args) {
        Cat cat[] = {new Cat("Oliver"), new Cat("Polly"), new Cat("Neko"), new Cat("Asya")};
        Plate plate = new Plate(50);

        for (Cat cats : cat) {
            cats.eat(plate);
            cats.info();
        }
        plate.refillFood(20);

        for (Cat cats : cat) {
            cats.eat(plate);
            cats.info();
        }
    }
}
