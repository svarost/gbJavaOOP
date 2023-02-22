package lesson4.items;

import lesson4.weapons.Weapon;

public abstract class Warrior<T extends Weapon> {
    private String name;
    protected T weapon;
    private int healthPoint;


    public Warrior(String name, T weapon) {
        this.name = name;
        this.weapon = weapon;
        healthPoint = 100;
    }


    public abstract int hitDamage();
    public int getMaxDamage() {
        return  weapon.damage();
    }

    @Override
    public String toString() {
        return "Warrior {" +
                "name= '" + name + '\'' +
                ", weapon= " + weapon +
                ", healthPoint= " + healthPoint +
                '}';
    }
}
