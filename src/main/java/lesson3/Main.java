package lesson3;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Bill", "Klinton", 98);
        User user2 = new User("Monika", "Livinsky", 48);
        User user3 = new User("Bill", "Gatse", 86);
        User user4 = new User("Tom", "Kruse", 65);
        User user5 = new User("Chipollino", "Radary", 198);

        User[] users = new User[]{user1, user2, user3, user4, user5};

        Personal personal = new Personal(users);

        for (User user : personal) {
            System.out.println(user);
        }
    }
}
