package Controller;

import Model.Student;
import Model.User;


public class UserController {

    private User loggedInUser;

    // Simulated login method (authentication placeholder)
    public boolean login(String username, String password) {
        // Here, we just check if the username matches and the password is "password123"
        // Replace this with actual authentication logic (e.g., database lookup)
        if ("student".equals(username) && "password123".equals(password)) {
            loggedInUser = new Student("Bobby", password, "FN12345", "Group A", 2, null);
            return true;
        } else if ("teacher".equals(username) && "password123".equals(password)) {
            loggedInUser = DataLoader.getInstance().getAllTeachers().get(0);
            return true;
        } else {
            return false;
        }
    }

    public void showUserCourses() {
        loggedInUser.showCourses();
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public String getUsername() {
        return loggedInUser.getName();
    }

    public String getPassword() {
        return loggedInUser.getPassword();
    }

    // Get the Faculty Number if the logged-in user is a Student
    public String getFacultyNumber() {
        if (loggedInUser instanceof Student student) {
            return student.getFacultyNumber();
        }
        return "N/A"; // Return N/A if the user is not a Student
    }

    // Get the Group if the logged-in user is a Student
    public String getGroup() {
        if (loggedInUser instanceof Student student) {
            return student.getGroup();
        }
        return "N/A"; // Return N/A if the user is not a Student
    }

    // Get the Year in University if the logged-in user is a Student
    public int getYearInUni() {
        if (loggedInUser instanceof Student student) {
            return student.getYearInUniversity();
        }
        return -1;
    }

    public void loggingOutUser() {
        loggedInUser = null;
    }

    public void setPassword(String password) {
        loggedInUser.setPassword(password);
    }

    public void setUserName(String newUsername) {
        loggedInUser.setName(newUsername);
    }

    public String getUserRole() {
        return loggedInUser.getRole();
    }
}
