package lesson4.items;

import lesson4.weapons.Bow;
import lesson4.protection.Shield;

import java.util.Random;

//public class Archer extends Warrior<Bow, Shield> implements DistanceAttacker {
public class Archer extends Warrior<Bow> implements DistanceAttacker {
    private int distance;
    private Random rnd = new Random();

    public Archer(String name, Bow weapon) {
        super(name, weapon);
        distance = weapon.getDistance() + rnd.nextInt();
    }

    public Archer(String name, Bow weapon, Shield shield) {
        super(name, weapon, shield);
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
