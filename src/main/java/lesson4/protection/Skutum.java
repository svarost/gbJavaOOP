package lesson4.protection;

public class Skutum implements Shield {
    private int protect = 70;

    public Skutum() {
    }

    public Skutum(int protect) {
        this.protect = protect;
    }

    @Override
    public int getProtect() {
        return protect;
    }

    @Override
    public String toString() {
        return "Sukum{" +
                "protect= " + getProtect() +
                '}';
    }
}
