package View;

import Controller.DataLoader;
import Controller.UserController;
import Model.Teacher;
import Model.common.StringResources;

import java.util.List;
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
        showWelcome();
    }

    public boolean logOutUser() {
        System.out.println("Are you sure you want to logout?\n");
        System.out.println("Press Y/N?\n");

        String input;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Are you sure you want to change your password?: ");
        boolean shouldLogOutUser = readYesOrNo();

        if (shouldLogOutUser) {
            System.out.println("You have successfully logged out!\n");
            userController.loggingOutUser(); // Assuming this logs out the user
        } else {
            System.out.println("Logout cancelled\n");
        }

        return shouldLogOutUser;
    }

    public void displayUserName() {
        System.out.println("Welcome, " + userController.getUsername());
    }

    public void displayRole() {
        System.out.println("Role: " + userController.getUserRole());
    }

    public void showWelcome() {
        if (userController.getLoggedInUser() != null) {
            this.displayUserName();
            this.displayRole();

            if (userController.getUserRole().equals(StringResources.STUDENT)) {
                System.out.println(userController.getFacultyNumber() + " | " +
                        userController.getGroup() + " | " +
                        userController.getYearInUni());
            }
        }
    }

    // Method to display menu options and handle commands
    public void showMenu() {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Show Available Courses");
            System.out.println("2. Show My Courses");
            System.out.println("3. Log out");
            System.out.println("4. Change Password");
            System.out.println("5. Change Name");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    showAvailableCourses();
                    break;
                case 2:
                    showMyCourses();
                    break;
                case 3:
                    if (logOutUser()) {
                        running = false; // Exit the loop after logout
                    }
                    break;
                case 4:
                    changePassword();
                    break;
                case 5:
                    changeName();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again\n");
                    break;
            }
        }
    }

    public void showAvailableCourses() {
        // Create a DataLoader instance to simulate "loading" data from a database
        DataLoader dataLoader = DataLoader.getInstance();

        // Load teachers and courses
        List<Teacher> teachers = dataLoader.getAllTeachers();

        System.out.println("\nAvailable courses: \n");

        // Display course information for the teachers (after login)
        for (Teacher teacher : teachers) {
            teacher.showCourses();
        }
    }

    public void showMyCourses() {
        userController.showUserCourses();
    }

    private boolean readYesOrNo() {
        String input;
        Scanner scanner = new Scanner(System.in);
        boolean result = false;

        System.out.println("Please enter Y/N: ");

        while (true) {
            input = scanner.nextLine().trim().toUpperCase(); // Convert input to uppercase to handle both cases
            if (input.equals("Y")) {
                result = true;
                break;
            } else if (input.equals("N")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter Y/N\n");
            }
        }

        return result;
    }

    public void changeName() {
        System.out.println("Are you sure you want to change the username?: ");

        if (readYesOrNo()) {
            System.out.println("Change username to: \n");

            Scanner scanner = new Scanner(System.in);

            String newUsername = scanner.nextLine();

            userController.setUserName(newUsername);

            System.out.println("Name changed successfully to: " + userController.getUsername());
        }
    }

    public void changePassword() {
        System.out.println("Are you sure you want to change your password?: ");

        if (readYesOrNo()) {
            System.out.println("Change password to: \n");

            Scanner scanner = new Scanner(System.in);

            String newPassword = scanner.nextLine();

            userController.setPassword(newPassword);

            System.out.println("Password changed successfully to: " + userController.getPassword());
        }
    }

}

