package lesson5.controllers;

import lesson5.model.Repository;
import lesson5.model.SaveFormat;
import lesson5.model.User;

import java.util.List;

import static lesson5.model.SaveFormat.TYPE_ONE;

public class UserController {
    private final Repository repository;

    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.createUser(user);
    }

    public User readUser(String userId) throws Exception {
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }

        throw new Exception("User not found");
    }

    public void deleteUser(User user) throws Exception {
        repository.deleteUser(user);

    }

    public List<User> listUsers() {
        List<User> users = repository.getAllUsers();
        return users;
    }

    public void updateUser(User user) {
        repository.updateUser(user);
    }

    public void setFormat(SaveFormat saveFormat) {
//        switch (saveFormat) {
//            case TYPE_ONE -> repository.setSaveFormat("TYPE_ONE");
//            case TYPE_TWO -> repository.setSaveFormat("TYPE_TWO");
//        }
        repository.setSaveFormat(saveFormat);
    }
}
