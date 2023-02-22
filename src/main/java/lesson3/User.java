package lesson3;

public class User implements Comparable<User>{
    private String firstName;
    private String lastName;
    private int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

//    public String toString(){
//        return "User{" + "firstName="
//    }

    @Override
    public int compareTo(User o) {
        return 0;
    }

    public Iterable<? extends User> getPersonal() {
        return null;
    }
}
