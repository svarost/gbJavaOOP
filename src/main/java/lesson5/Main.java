package lesson5;

import lesson5.controllers.UserController;
import lesson5.model.FileOperation;
import lesson5.model.FileOperationImpl;
import lesson5.model.Repository;
import lesson5.model.RepositoryFile;
import lesson5.views.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("users.txt");
        Repository repository = new RepositoryFile(fileOperation);
        UserController controller = new UserController(repository);
        ViewUser view = new ViewUser(controller);
        view.run();
    }
}
