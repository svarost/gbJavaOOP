package lesson5.model;

import java.util.List;

public interface Repository {
    List<User> getAllUsers();
    String createUser(User user);
    String deleteUser(User user);
    String updateUser(User user);
    void setSaveFormat(SaveFormat saveFormat);
}
