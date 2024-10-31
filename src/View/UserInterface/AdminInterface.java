package View.UserInterface;

import Controller.DataLoader;
import Controller.UserController;
import Model.Admin;
import Model.Course;
import Model.Student;
import Model.Teacher;
import Model.common.StringResources;

import java.util.Objects;
import java.util.Scanner;

public class AdminInterface extends BaseInterface {

    public AdminInterface(UserController userController) {
        super(userController);
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have chosen option - createUser");

        System.out.println("Username: ");
        String username = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();


        System.out.println("Available roles: Admin, Student, Teacher");
        System.out.println("Role: ");
        String role = scanner.nextLine();

        while (!isValidRole(role)) {
            System.out.println("Invalid role, try again");
            role = scanner.nextLine();
        }

        if (userController.getLoggedInUser() instanceof Admin admin) {
            admin.createUser(username, password, role);
        }
    }

    public void addCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter course name: ");
        String courseName = scanner.nextLine();

        if (userController.getLoggedInUser() instanceof Admin admin) {
            admin.addCourse(courseName);
        }
    }

    public void addGradeToStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter course name: ");
        String courseName = scanner.nextLine();

        System.out.println("Please enter student name: ");
        String studentName = scanner.nextLine();

        System.out.println("Please enter student's grade: ");
        int grade = Integer.parseInt(scanner.nextLine());

        if (userController.getLoggedInUser() instanceof Admin admin) {
            admin.addGradeToStudent(courseName, studentName, grade);
        }
    }

    private void markStudentAsPassed() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter course name: ");
        String courseName = scanner.nextLine();

        System.out.println("Please enter student name: ");
        String studentName = scanner.nextLine();

        if (userController.getLoggedInUser() instanceof Admin admin) {
            admin.markStudentAsPassed(studentName, courseName);
        }
    }

    private void addStudentToCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter course name: ");
        String courseName = scanner.nextLine();

        Course course = DataLoader.getInstance().getAdditionalCourse(courseName);
        if (course == null) {
            course = DataLoader.getInstance().getBaseCourse(courseName);
            if (course == null) {
                System.out.println("Course not found, aborting operation\n");
                return;
            }
        }

        System.out.println("Please enter student name: ");
        String studentName = scanner.nextLine();

        Student student = DataLoader.getInstance().getStudent(studentName);
        if (student == null) {
            System.out.println("Student not found, aborting operation\n");
            return;
        }

        student.addCourse(course);
    }

    private void addTeacherToCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter course name: ");
        String courseName = scanner.nextLine();

        Course course = DataLoader.getInstance().getAdditionalCourse(courseName);
        if (course == null) {
            course = DataLoader.getInstance().getBaseCourse(courseName);
            if (course == null) {
                System.out.println("Course not found, aborting operation\n");
                return;
            }
        }

        System.out.println("Please enter teacher's name: ");
        String teacherName = scanner.nextLine();

        Teacher teacher = DataLoader.getInstance().getTeacher(teacherName);
        if (teacher == null) {
            System.out.println("Teacher not found, aborting operation\n");
            return;
        }

        if (teacher.addCourse(course)) {
            System.out.println("Course added successfully\n");
        } else {
            System.out.println("Problem in adding\n");
        }
    }

    public void removeTeacheFromCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter course name: ");
        String courseName = scanner.nextLine();

        boolean isAdditionalCourse = true;
        Course course = DataLoader.getInstance().getAdditionalCourse(courseName);
        if (course == null) {

            course = DataLoader.getInstance().getBaseCourse(courseName);

            if (course == null) {
                System.out.println("Course not found, aborting operation\n");
                return;
            }

            isAdditionalCourse = false;
        }

        System.out.println("Please enter teacher's name: ");
        String teacherName = scanner.nextLine();

        Teacher teacher = DataLoader.getInstance().getTeacher(teacherName);
        if (teacher == null) {
            System.out.println("Teacher not found, aborting operation\n");
            return;
        }

        //removing from course list
        if (isAdditionalCourse) {
            DataLoader.getInstance().getAdditionalCourse(courseName).setTeacher("Unknown");
        } else {
            DataLoader.getInstance().getBaseCourse(courseName).setTeacher("Unknown");
        }

        //removing from teachers list
        DataLoader.getInstance().getTeacher(teacherName).getCourses().remove(course);
    }

    public void removeStudentFromCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter course name: ");
        String courseName = scanner.nextLine();

        Course course = DataLoader.getInstance().getAdditionalCourse(courseName);
        if (course == null) {

            course = DataLoader.getInstance().getBaseCourse(courseName);

            if (course == null) {
                System.out.println("Course not found, aborting operation\n");
                return;
            }
        }

        System.out.println("Please enter students's name: ");
        String studentName = scanner.nextLine();

        Student student = DataLoader.getInstance().getStudent(studentName);
        if (student == null) {
            System.out.println("Student not found, aborting operation\n");
            return;
        }

        //removing from teachers list
        DataLoader.getInstance().getStudent(studentName).getCourses().remove(course);
    }

    public void createStudentSpecialty() {
        System.out.println("This option is not added yet, sorry");
        //TODO: Implement

        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Please enter new specialty name: ");
    }


    @Override
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Show Available Courses");
            System.out.println("2. Create User");
            System.out.println("3. Log out");
            System.out.println("4. Change Password");
            System.out.println("5. Change Name");
            System.out.println("6. Add course");
            System.out.println("7. Add grade to a student");
            System.out.println("8. Mark student as passed at course");
            System.out.println("9. Add student at course");
            System.out.println("10. Add teacher at course");
            System.out.println("11. Remove teacher from course");
            System.out.println("12. Remove student from course");
            System.out.println("13. Create student specialty");
            System.out.print("Enter your choice (1-13): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    showAvailableCourses();
                    break;
                case 2:
                    createUser();
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
                case 10:
                    addTeacherToCourse();
                    break;
                case 11:
                    removeTeacheFromCourse();
                    break;
                case 12:
                    removeStudentFromCourse();
                    break;
                case 13:
                    createStudentSpecialty();
                    break;


                default:
                    System.out.println("Invalid choice. Please try again\n");
                    break;
            }
        }
    }


    public boolean isValidRole(String input) {
        if (Objects.equals(input, StringResources.ADMIN)) return true;
        else if (Objects.equals(input, StringResources.STUDENT)) return true;
        else return Objects.equals(input, StringResources.TEACHER);
    }
}
