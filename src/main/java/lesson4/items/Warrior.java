package lesson4.items;

import lesson4.protection.Shield;
import lesson4.weapons.Weapon;

//public abstract class Warrior<T extends Weapon, D extends Shield> {
public abstract class Warrior<T extends Weapon> {
    private String name;
    protected T weapon;
    //    protected D shield;
    protected Shield shield;
    private int healthPoint;

    //    public Warrior(String name, T weapon, D shield) {
    public Warrior(String name, T weapon) {
        this.name = name;
        this.weapon = weapon;
        shield = null;
        healthPoint = 100;
    }

    public Warrior(String name, T weapon, Shield shield) {
        this.name = name;
        this.weapon = weapon;
        this.shield = shield;
        healthPoint = 100;
    }

    public abstract int hitDamage();

    public int getMaxDamage() {
        return weapon.damage();
    }

    @Override
    public String toString() {
        return "Warrior {" +
                "name= '" + name + '\'' +
                ", weapon= " + weapon +
                ", shield= " + shield +
                ", healthPoint= " + healthPoint +
                '}';
    }

    public Shield getShield() {
        if (shield == null) {
            return null;
        }
        else {
            return shield;
        }
    }
}
