package lesson5.model;

public class UserMapperTypeTwo implements UserMapper{
    @Override
    public String map(User user) {
        return String.format("%s;%s;%s;%s\n", user.getId(), user.getFirstName(), user.getLastName(), user.getPhone());
    }

    @Override
    public User map(String line) {
        String[] lines = line.split(";");
        return new User(lines[0], lines[1], lines[2], lines[3]);
    }
}
