import java.util.Date;

public class Drink extends Product {
    private Date loadDate = new Date();

    public Drink(String name, double cost) {
        super(name, cost);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
