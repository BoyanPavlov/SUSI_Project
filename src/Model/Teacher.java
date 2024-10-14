package Model;

import Model.common.StringResources;

import java.util.List;

public class Teacher extends User {
    private List<Course> courses;

    public Teacher(String name, String password, List<Course> courses) {
        super(name, password);
        this.courses = courses;
        this.role = StringResources.TEACHER;
    }

    // Getters and Setters
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // Method to display all courses taught by the teacher
    @Override
    public void showCourses() {
        if (courses != null && !courses.isEmpty()) {
            for (Course course : courses) {
                System.out.println(course.getName() + " (" + course.getPeriod() + ")");
            }
        } else {
            System.out.println("No courses assigned.");
        }
    }

    @Override
    public String getRole() {
        return this.role;
    }
}
