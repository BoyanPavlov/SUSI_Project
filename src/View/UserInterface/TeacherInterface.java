package View.UserInterface;

import Controller.DataLoader;
import Controller.UserController;
import Model.Course;
import Model.Student;
import Model.Teacher;

import java.util.Scanner;

public class TeacherInterface extends BaseInterface {

    public TeacherInterface(UserController userController) {
        super(userController);
    }

    public void addCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter course name: ");
        String courseName = scanner.nextLine();

        String teacherName = userController.getUsername();
        Course courseToBeAdded = new Course(courseName, "Summer 2025", teacherName, 30);

        userController.addAdditionalCourse(courseToBeAdded);
    }

    public void addGradeToStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter course name: ");
        String courseName = scanner.nextLine();

        if (!doesTeacherHasAccessToThisCourse(courseName)) {
            System.out.println("Sorry, but you don't have access to this course: ");
            return;
        }

        System.out.println("Please enter student name: ");
        String studentName = scanner.nextLine();

        System.out.println("Please enter student's grade: ");
        int grade = Integer.parseInt(scanner.nextLine());

        Student student = DataLoader.getInstance().getStudent(studentName);
        if (student != null) {
            student.changeGrade(courseName, grade);
        }
    }

    private boolean doesTeacherHasAccessToThisCourse(String courseName) {
        if (userController.getLoggedInUser() instanceof Teacher teacher) {
            return teacher.doesTeacherHasAccessToThisCourse(courseName);
        }
        return false;
    }

    private void markStudentAsPassed() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter course name: ");
        String courseName = scanner.nextLine();

        if (!doesTeacherHasAccessToThisCourse(courseName)) {
            System.out.println("Sorry, but you don't have access to this course: ");
            return;
        }

        System.out.println("Please enter student name: ");
        String studentName = scanner.nextLine();

        Student student = DataLoader.getInstance().getStudent(studentName);
        if (student != null) {
            int grade = student.getGradeAtCourse(courseName);
            if (grade <= 2) {
                student.changeGrade(courseName, 3);
            }
        }
    }

    private void addStudentToCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter course name: ");
        String courseName = scanner.nextLine();

        if (!doesTeacherHasAccessToThisCourse(courseName)) {
            System.out.println("Sorry, but you don't have access to this course: ");
            return;
        }

        System.out.println("Please enter student name: ");
        String studentName = scanner.nextLine();

        Student student = DataLoader.getInstance().getStudent(studentName);
        Course course = DataLoader.getInstance().getAdditionalCourse(courseName);
        student.addCourse(course);
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
            System.out.println("6. Add course");
            System.out.println("7. Add grade to a student");
            System.out.println("8. Mark student as passed at course");
            System.out.println("9. Add student at course");
            System.out.print("Enter your choice (1-9): ");

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
                    addCourse();
                    break;
                case 7:
                    addGradeToStudent();
                    break;
                case 8:
                    markStudentAsPassed();
                    break;
                case 9:
                    addStudentToCourse();
                    break;


                default:
                    System.out.println("Invalid choice. Please try again\n");
                    break;
            }
        }
    }

    public void showMyCourses() {
        userController.showUserCourses();
    }
}
