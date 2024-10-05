import Controller.DataLoader;
import Model.Teacher;
import View.ConsoleView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a DataLoader instance to simulate "loading" data from a database
        DataLoader dataLoader = new DataLoader();

        // Load teachers and courses
        List<Teacher> teachers = dataLoader.loadTeachersAndCourses();

        // Create a ConsoleView instance
        ConsoleView view = new ConsoleView();

        // Start the app with login
        view.showLogin();

        // Display course information for the teachers (after login)
        for (Teacher teacher : teachers) {
            System.out.println("Courses taught by " + teacher.getName() + ":");
            teacher.showCourses();
        }
    }
}

/*
Based on the input, the UserController simulates a login
(you can use student/password123 or
teacher/password123 as valid credentials).
*/
