import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.addProduct(new Product("Lays", 100));
        machine.addProduct(new Product("Mars", 70));
        machine.addProduct(new Product("Twix", 70.99));
        machine.addProduct(new Product("Алёнка", 90));
        machine.addProduct(new Product("Колокольчик", 85));
        machine.addProduct(new Perishable("Молоко Бурёнка", 85, new Date(2023, 1, 25)));
        machine.addProduct(new Perishable("Молоко Коровка", 85, new Date(2023, 1, 25)));
        machine.addProduct(new Perishable("Молоко Василёк", 85, new Date(2023, 1, 25)));
        machine.addProduct(new Drink("Байкал", 53));
        machine.addProduct(new Drink("Тархун", 55));
        machine.addProduct(new Drink("Колокольчик", 50));

        System.out.println(machine);
        System.out.println("__________________________________");
        System.out.println(machine.findProduct("Молоко"));
        System.out.println(machine.findProduct("Алёнка"));
        System.out.println(machine.findProduct("Пиво"));
        System.out.println("__________________________________");
        System.out.println("Продан: " + machine.sellProduct(machine.findProduct("Twix").get(0)));
        System.out.println("Продан: " + machine.sellProduct(machine.findProduct("Колокольчик").get(0)));
        System.out.println("__________________________________");
        System.out.println(machine);


    }
}