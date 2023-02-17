package lesson2.zoo;

import lesson2.zoo.radio.Sayable;

public abstract class Animal implements Sayable {

    private String name;

    protected Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract String feed();

    @Override
    public String toString() {
        StringBuilder srt = new StringBuilder();
        if (this instanceof Runable) {
            srt.append(" Скорость бега - > " + ((Runable) this).getSpeedRun());
        }
        if (this instanceof Flyable) {
            srt.append(" Скорость полёта - > " + ((Flyable) this).getSpeedFlyable());
        }
        if (this instanceof Floatable) {
            srt.append(" Скорость плавания - > " + ((Floatable) this).getSpeedFloat());
        }
        return String.format(srt + " %s ест %s", this.name, this.feed());
    }
}