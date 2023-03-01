package lesson4.teams;

import lesson4.items.DistanceAttacker;
import lesson4.items.Warrior;
import lesson4.protection.Shield;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;

public class Team<T extends Warrior> {
    private List<T> team = new ArrayList<>();
    private String name;

    public Team(String name) {
        this.name = name;
    }


    public Team<T> addWarrior(T warrior) {
        team.add(warrior);
        return this;
    }

    public String toString() {
        StringBuilder teamBuilder = new StringBuilder();
        for (T item : team) {
            teamBuilder.append(item.toString() + "\n");
        }
        return String.format("Team{team= %s %s}",
                name, teamBuilder);
    }

    public int getMaxDistance() {
        int distance = 0;
        for (T item : team) {
            if (!(item instanceof DistanceAttacker)) {
                continue;
            }
            DistanceAttacker temp = (DistanceAttacker) item;
            if (temp.getDistance() > distance) {
                distance = temp.getDistance();
            }
        }
        return distance;
    }

    public Shield minShield() {
        List<Shield> shields = new ArrayList<>();
        for (T unit : team) {
            if (unit.getShield() != null) {
                shields.add(unit.getShield());
            }
        }

        Shield minShield = shields.get(0);
        for (Shield shield : shields) {
            if (minShield.getProtect() > shield.getProtect()) {
                minShield = shield;
            }
        }
        return minShield;
    }
}
