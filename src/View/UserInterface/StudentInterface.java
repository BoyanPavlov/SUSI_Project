package View.UserInterface;


import Controller.UserController;
import Model.Course;
import Model.common.StringResources;

import java.util.Objects;
import java.util.Scanner;

public class StudentInterface extends BaseInterface {

    public StudentInterface(UserController userController) {
        super(userController);
    }

    public void showMyCourses() {
        userController.showUserCourses();
    }

    private void signAdditionalCourse() {
        userController.showAdditionalCourses();

        System.out.println("\nEnter Additional Course Name: ");
        Scanner scanner = new Scanner(System.in);
        String courseName = scanner.nextLine();

        Course courseToBeAdded = userController.getAdditionalCourse(courseName);

        while (courseToBeAdded == null && !Objects.equals(courseName, "exit")) {
            System.out.println("\nEnter Additional Course Name or enter exit");
            courseName = scanner.nextLine();
            courseToBeAdded = userController.getAdditionalCourse(courseName);
        }

        if (!courseName.equals("exit")) {
            userController.addAdditionalCourse(courseToBeAdded);
            System.out.println("\nCourse successfully added");
        }
    }

    @Override
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
            System.out.println("6. Sign me to additional course");
            System.out.print("Enter your choice (1-6): ");

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
                case 6:
                    signAdditionalCourse();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again\n");
                    break;
            }
        }
    }

}
