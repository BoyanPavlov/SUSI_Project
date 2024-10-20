package Controller;

import Model.*;
import Model.common.StringResources;

import java.util.List;
import java.util.Objects;


public class UserController {

    private User loggedInUser;

    // Simulated login method (authentication placeholder)
    public boolean login(String username, String password) {
        // Here, we just check if the username matches and the password is "password123"

        List<Teacher> allTeachers = DataLoader.getInstance().getAllTeachers();
        List<Student> allStudents = DataLoader.getInstance().getAllStudents();
        List<Admin> allAdmins = DataLoader.getInstance().getAllAdmins();

        for (Student student : allStudents) {
            if (student.getName().equals(username) && student.getPassword().equals(password)) {
                loggedInUser = student;
                return true;
            }
        }

        for (Teacher teacher : allTeachers) {
            if (teacher.getName().equals(username) && teacher.getPassword().equals(password)) {
                loggedInUser = teacher;
                return true;
            }
        }

        for (Admin admin : allAdmins) {
            if (admin.getName().equals(username) && admin.getPassword().equals(password)) {
                loggedInUser = admin;
                return true;
            }
        }

        return false;
    }

    public void showUserCourses() {
        if (loggedInUser instanceof Teacher teacher) {
            if (!Objects.equals(teacher.getName(), StringResources.UNKNOWN))
                teacher.showCourses();
        } else if (loggedInUser instanceof Student student) {
            student.showCourses();
        }
    }

    public void showAdditionalCourses() {
        if (loggedInUser instanceof Student) {
            ((Student) loggedInUser).showAdditionalCourses();
        }
    }

    public Course getAdditionalCourse(String input) {
        Course result = null;
        List<Course> additionalCourses = DataLoader.getInstance().getAdditionalCourses();

        for (Course course : additionalCourses) {
            if (course.getName().equals(input)) {
                result = course;
                break;
            }
        }
        return result;
    }

    public void addAdditionalCourse(Course course) {
        if (loggedInUser instanceof Student) {
            ((Student) loggedInUser).addCourse(course);
        } else if (loggedInUser instanceof Teacher) {
            ((Teacher) loggedInUser).addCourse(course);
        }

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
