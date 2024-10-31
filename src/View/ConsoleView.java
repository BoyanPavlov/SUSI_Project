package View;

import Controller.UserController;
import Model.common.StringResources;
import View.UserInterface.AdminInterface;
import View.UserInterface.BaseInterface;
import View.UserInterface.StudentInterface;
import View.UserInterface.TeacherInterface;

import java.util.Scanner;

public class ConsoleView {
    private final UserController userController;

    public ConsoleView() {
        this.userController = new UserController();
    }

    public void showLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login to the system");

        String username;
        String password;
        boolean isUserLoggedIn;

        do {
            System.out.print("Username: ");
            username = scanner.nextLine();

            System.out.print("Password: ");
            password = scanner.nextLine();

            isUserLoggedIn = userController.login(username, password);

            if (!isUserLoggedIn) {
                System.out.println("Invalid credentials, please try again.\n");
            }
        }
        while (!isUserLoggedIn);

        System.out.println("Login successful!\n");
    }

    public void showUserInterface() {
        if (userController.getLoggedInUser() != null) {

            BaseInterface userInterface = switch (userController.getUserRole()) {
                case StringResources.ADMIN -> new AdminInterface(userController);
                case StringResources.TEACHER -> new TeacherInterface(userController);
                case StringResources.STUDENT -> new StudentInterface(userController);
                default -> throw new IllegalArgumentException("Invalid user role");
            };

            userInterface.showMenu();

        }
    }
}

