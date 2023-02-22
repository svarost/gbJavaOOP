package lesson4;

import lesson4.items.Archer;
import lesson4.items.SwordMan;
import lesson4.items.Warrior;
import lesson4.teams.Team;
import lesson4.weapons.Bow;
import lesson4.weapons.Sword;

public class Main {
    public static void main(String[] args) {
        Team<Archer> archerTeam = new Team<>("Archers");
        archerTeam.addWarrior(new Archer("Григорий", new Bow()))
                    .addWarrior(new Archer("Вася", new Bow()))
                    .addWarrior(new Archer("Петя", new Bow()))
                    .addWarrior(new Archer("Иннакентий", new Bow()));


        System.out.println(archerTeam);

        Team<Warrior> mixTeam = new Team<>("Archers");
        mixTeam.addWarrior(new Archer("Григорий", new Bow()))
                .addWarrior(new SwordMan("Вася", new Sword()))
                .addWarrior(new Archer("Петя", new Bow()))
                .addWarrior(new Archer("Иннакентий", new Bow()));

        System.out.println(mixTeam);
    }
}
