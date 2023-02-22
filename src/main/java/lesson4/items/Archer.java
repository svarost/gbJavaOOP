package lesson4.items;

import lesson4.weapons.Bow;

import java.util.Random;

public class Archer extends Warrior<Bow> implements DistanceAttacker {
    private int distance;
    private Random rnd = new Random();


    public Archer(String name, Bow weapon) {
        super(name, weapon);
        distance = weapon.getDistance() + rnd.nextInt();
    }

    @Override
    public int hitDamage() {
        return new Random().nextInt(weapon.damage());
    }

    public int getDistance() {
        return distance;
    }


    @Override
    public String toString() {
        return super.toString() + " \nArcher {" +
                "distance= " + distance +
                '}';
    }
}
