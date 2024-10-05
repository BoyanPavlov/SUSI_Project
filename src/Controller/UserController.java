package Controller;

import Model.User;
import Model.Student;
import Model.Teacher;

public class UserController {
    private User loggedInUser;

    // Simulated login method (authentication placeholder)
    public boolean login(String username, String password) {
        // Here, we just check if the username matches and the password is "password123"
        // Replace this with actual authentication logic (e.g., database lookup)
        if ("student".equals(username) && "password123".equals(password)) {
            loggedInUser = new Student(username, password, "FN12345", "Group A", 2, null);
            return true;
        } else if ("teacher".equals(username) && "password123".equals(password)) {
            loggedInUser = new Teacher(username, password, null);
            return true;
        } else {
            return false;
        }
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}
