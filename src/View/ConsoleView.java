package View;

import Controller.UserController;
import Model.User;

import java.util.Scanner;

public class ConsoleView {
    private UserController userController;

    public ConsoleView() {
        this.userController = new UserController();
    }

    public void showLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login to the system");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean success = userController.login(username, password);

        if (success) {
            System.out.println("Login successful!\n");
            showWelcome();
        } else {
            System.out.println("Invalid credentials, please try again.\n");
        }
    }

    public void showWelcome() {
        User user = userController.getLoggedInUser();
        if (user != null) {
            System.out.println("Welcome, " + user.getName());
            user.displayRole();
        }
    }
}

