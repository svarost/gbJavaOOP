package lesson5.views;

import lesson5.controllers.UserController;
import lesson5.model.SaveFormat;
import lesson5.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ViewUser {

    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt("\nВведите команду: ").toUpperCase();
            try {
                com = Commands.valueOf(command);
                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE -> createUser();
                    case LIST -> listUser();
                    case READ -> readUser();
                    case DELETE -> deleteUser();
                    case UPDATE -> updateUser();
                    case SAVEFORMAT -> setSaveFormat();
                }
            } catch (IllegalArgumentException e) {
                System.out.print("Введена недопустимая команда.\n");
            }
        }
    }

    private void setSaveFormat() {
        SaveFormat saveFormat = SaveFormat.TYPE_ONE;
        boolean exist = true;

        List<SaveFormat> arrayList = Arrays.asList(SaveFormat.values());
        ArrayList<String> nameEnum = new ArrayList<>();
        for (SaveFormat item : arrayList) {
            nameEnum.add(item.name());
        }

        while (exist) {
            String format = prompt("Введите формат сохранения в файл: ").toUpperCase();
//            System.out.println(Arrays.asList(SaveFormat.values()));
            if (nameEnum.contains(format)) {
                userController.setFormat(SaveFormat.valueOf(format));
                exist = false;
            } else {
                System.out.println("Фармат сохренения задан не верно.");
            }
        }
    }


    private void updateUser() {
        String id = prompt("Идентификатор пользователя: ");
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        try {
            User user = userController.readUser(id);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPhone(phone);
            userController.updateUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteUser() {
        String id = prompt("Идентификатор пользователя: ");

        try {
            User user = userController.readUser(id);
            userController.deleteUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void readUser() {
        String id = prompt("Идентификатор пользователя: ");
        try {
            User user = userController.readUser(id);
            System.out.println(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void listUser() {
        List<User> users = userController.listUsers();
        if (users.isEmpty()) System.out.println("Польлзователи отсутствуют.");

        for (User user : users) {
            System.out.println(user);
        }
    }

    private void createUser() {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        userController.saveUser(new User(firstName, lastName, phone));
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
