package View.UserInterface;

import Controller.DataLoader;
import Controller.UserController;
import Model.Teacher;
import Model.common.StringResources;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class BaseInterface {
    protected UserController userController;

    public BaseInterface(UserController userController) {

        this.userController = userController;
        showWelcome();
    }

    public boolean logOutUser() {
        System.out.println("Are you sure you want to logout?\n");
        System.out.println("Press Y/N?\n");

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

    public void showAvailableCourses() {
        // Create a DataLoader instance to simulate "loading" data from a database
        DataLoader dataLoader = DataLoader.getInstance();

        // Load teachers and courses
        List<Teacher> teachers = dataLoader.getAllTeachers();

        System.out.println("\nAvailable courses: \n");

        // Display course information for the teachers (after login)
        for (Teacher teacher : teachers) {
            if (!Objects.equals(teacher.getName(), StringResources.UNKNOWN)) {
                teacher.showCourses();
            }
        }
    }

    // Method to display menu options and handle commands
    public abstract void showMenu();

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
}
