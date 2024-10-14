package Model;

import Controller.DataLoader;
import Model.common.StringResources;

import java.util.List;

public class Student extends User {
    private String facultyNumber;
    private String group;
    private int yearInUniversity;
    private List<Course> courses;

    public Student(String name, String password, String facultyNumber
            , String group, int yearInUniversity, List<Course> courses) {
        super(name, password);
        this.facultyNumber = facultyNumber;
        this.group = group;
        this.yearInUniversity = yearInUniversity;
        this.courses = DataLoader.getInstance().getBaseCourses();
        this.role = StringResources.STUDENT;
    }

    // Getters and Setters
    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getYearInUniversity() {
        return yearInUniversity;
    }

    public void setYearInUniversity(int yearInUniversity) {
        this.yearInUniversity = yearInUniversity;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void showCourses() {
        System.out.println("\nCourses of a student with FN: " + facultyNumber + " are:\n");

        if (courses != null && !courses.isEmpty()) {
            for (Course course : courses) {
                System.out.println(course.getName() + " - " + course.getTeacher() +
                        " (" + course.getPeriod() + ")");
            }
        } else {
            System.out.println("You don't have any courses.");
        }
    }

    @Override
    public String getRole() {
        return this.role;
    }
}

