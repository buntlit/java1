package gb.lesson7;

public class Plate {
    int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int eat) {
        if (eat <= food) {
            food -= eat;
            return true;
        }
        return false;
    }

    public void refillFood(int add) {
        food += add;
        System.out.println("Refill " + add + " in plate");
    }
}
