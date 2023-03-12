package lesson5.model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private UserMapper mapper;
    private FileOperation fileOperation;
    private SaveFormat saveFormat;

    public RepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
        mapper = new UserMapperTypeOne();

    }

    public RepositoryFile(FileOperation fileOperation, SaveFormat saveFormat) {
        this.fileOperation = fileOperation;
        this.saveFormat = saveFormat;
    }

    private void mapperSet(SaveFormat saveFormat) {
        switch (this.saveFormat) {
            case TYPE_ONE -> mapper = new UserMapperTypeOne();
            case TYPE_TWO -> mapper = new UserMapperTypeTwo();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<String> lines = fileOperation.readAllLines();
        System.out.println(lines);
        lines.removeIf(String::isEmpty);
        System.out.println(lines);
        List<User> users = new ArrayList<>();
        for (String line : lines) {
            users.add(mapper.map(line));
        }
        return users;
    }

    @Override
    public String createUser(User user) {

        List<User> users = getAllUsers();
        int max = 0;
        for (User item : users) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        System.out.println("id = " + id);
        user.setId(id);
        users.add(user);
        List<String> lines = new ArrayList<>();
        for (User item: users) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
        return id;
    }

    @Override
    public String deleteUser(User user) {
        List<User> users = getAllUsers();
        List<User> temp = new ArrayList<>();

        for (User item : users) {
            if (!item.getId().equals(user.getId())) {
                temp.add(item);
            }
        }
        List<String> lines = new ArrayList<>();
        for (User item: temp) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
        return String.format("User with ID= %s deleted", user.getId());
    }

    @Override
    public String updateUser(User user) {
        List<User> users = getAllUsers();
        List<User> temp = new ArrayList<>();

        for (User item : users) {
            if (item.getId().equals(user.getId())) {
                temp.add(user);
            }
            else {
                temp.add(item);
            }
        }
        List<String> lines = new ArrayList<>();
        for (User item: temp) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
        return String.format("User with ID= %s updated", user.getId());
    }

    @Override
    public void setSaveFormat(SaveFormat saveFormat) {
        List<User> users = getAllUsers();

        switch (saveFormat) {
            case TYPE_ONE -> mapper = new UserMapperTypeOne();
            case TYPE_TWO -> mapper = new UserMapperTypeTwo();
        }

        List<String> lines = new ArrayList<>();
        for (User item: users) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }
}
