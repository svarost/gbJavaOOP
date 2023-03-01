package lesson4.items;

import lesson4.weapons.Sword;
import lesson4.protection.Shield;

import java.util.Random;

public class SwordMan extends Warrior<Sword> {

    public SwordMan(String name, Sword weapon, Shield shield) {
        super(name, weapon, shield);
    }

    @Override
    public int hitDamage() {
        return new Random().nextInt(weapon.damage());
    }


    @Override
    public String toString() {
        return super.toString() + "SwordMan";
    }
}
