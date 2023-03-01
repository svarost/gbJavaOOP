package lesson4.protection;

public class Buckler implements Shield {
    private int protect = 30;

    public Buckler() {
    }

    public Buckler(int protect) {
        this.protect = protect;
    }

    @Override
    public int getProtect() {
        return protect;
    }

    @Override
    public String toString() {
        return "Buckler{" +
                "protect= " + getProtect() +
                '}';
    }
}
