package lesson2.zoo;

public class Dolphin extends Animal implements Floatable {
    private int floatSpeed = 360;

    public Dolphin(String name) {
        super(name);
    }

    @Override
    public String feed() {
        return "fish";
    }

    @Override
    public int getSpeedFloat() {
        return floatSpeed;
    }

    @Override
    public String say() {
        return "Creectk-uuu-aictck";
    }
}
