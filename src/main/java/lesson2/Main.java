package lesson2;

import lesson2.zoo.*;
import lesson2.zoo.radio.Radio;
import lesson2.zoo.radio.Sayable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Animal> animalsList = List.of(
                new Cow("Мурка"),
                new Crocodile("Гена"),
                new Leo("Симба - Леопольд"),
                new Goat("Маруська"),
                new Duck("Дональд Дак"),
                new Dolphin("Фидель")
        );
        Zoo zoo = new Zoo(animalsList, new Radio());

        for (Sayable animal : zoo.getSayable()) {
            System.out.println(animal.say());
        }
        System.out.println("______________________");
        for (Runable animal : zoo.getRunableList()) {
            System.out.println(((Animal) animal).getName());
            System.out.println(((Animal) animal).say());
            System.out.println(animal.getSpeedRun() + "\n");
        }
        System.out.println("______________________");
        for (Flyable animal : zoo.getFlyableList()) {
            System.out.println(((Animal) animal).getName());
            System.out.println(((Animal) animal).say());
            System.out.println(animal.getSpeedFlyable());
            System.out.println(animal.getHigh() + "\n");
        }
        System.out.println("______________________");
        for (Floatable animal : zoo.getFloatableList()) {
            System.out.println(((Animal) animal).getName());
            System.out.println(((Animal) animal).say());
            System.out.println(animal.getSpeedFloat());
        }
        System.out.println("____Определяем чемпиона по бегу_____");
        System.out.println(zoo.getRunChampion());
        System.out.println("____Определяем чемпиона по полётам_______");
        System.out.println(zoo.getFlightChampion());
        System.out.println("____Определяем чемпиона по плаванью_______");
        System.out.println(zoo.getFloatChampion());

    }
    //https://www.plantuml.com/
}