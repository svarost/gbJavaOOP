package lesson4.weapons;

public class Sword implements Weapon {
    @Override
    public int damage() {
        return 50;
    }

    @Override
    public String toString() {
        return "Sword{ damage= " + damage() + "}";
    }
}
