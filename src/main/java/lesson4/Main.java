package lesson4;

import lesson4.items.Archer;
import lesson4.items.SwordMan;
import lesson4.items.Warrior;
import lesson4.protection.Buckler;
import lesson4.protection.Skutum;
import lesson4.teams.Team;
import lesson4.weapons.Bow;
import lesson4.weapons.Sword;

public class Main {
    public static void main(String[] args) {
        Team<Archer> archerTeam = new Team<Archer>("Archers");
        archerTeam.addWarrior(new Archer("Григорий", new Bow(), new Buckler(10)))
                .addWarrior(new Archer("Вася", new Bow(), new Buckler(0)))
                .addWarrior(new Archer("Петя", new Bow(), new Buckler()))
                .addWarrior(new Archer("Иннакентий", new Bow(), new Buckler()));


        System.out.println(archerTeam);
        System.out.println("\nМинимальный щит в команде: " + archerTeam.minShield() + "\n");

        Team<Warrior> mixTeam = new Team<Warrior>("Archers");
        mixTeam.addWarrior(new Archer("Григорий", new Bow(), new Buckler()))
                .addWarrior(new SwordMan("Вася", new Sword(), new Buckler(25)))
                .addWarrior(new Archer("Петя", new Bow(), new Skutum(90)))
                .addWarrior(new Archer("Иннакентий", new Bow()));

        System.out.println(mixTeam);

        System.out.println("\nМинимальный щит в команде: " + mixTeam.minShield());
    }
}
