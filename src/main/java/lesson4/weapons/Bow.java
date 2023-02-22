package lesson4.weapons;

public class Bow implements Weapon {
    private int distance = 30;
    @Override
    public int damage() {
        return 50;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Bow{" +
                "distance= " + distance +
                ", damage= " + damage() +
                '}';
    }
}
