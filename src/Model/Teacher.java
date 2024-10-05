package Model;

import java.util.List;

public class Teacher extends User {
    private List<Course> courses;

    public Teacher(String name, String password, List<Course> courses) {
        super(name, password);
        this.courses = courses;
    }

    // Getters and Setters
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // Method to display all courses taught by the teacher
    public void showCourses() {
        System.out.println("Courses taught by " + getName() + ":");
        if (courses != null && !courses.isEmpty()) {
            for (Course course : courses) {
                System.out.println(" - " + course.getName() + " (" + course.getPeriod() + ")");
            }
        } else {
            System.out.println("No courses assigned.");
        }
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Teacher");
    }
}
