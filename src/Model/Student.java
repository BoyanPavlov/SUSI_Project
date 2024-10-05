package Model;

import java.util.List;

public class Student extends User {
    private String facultyNumber;
    private String group;
    private int yearInUniversity;
    private List<Course> courses;

    public Student(String name, String password, String facultyNumber, String group, int yearInUniversity, List<Course> courses) {
        super(name, password);
        this.facultyNumber = facultyNumber;
        this.group = group;
        this.yearInUniversity = yearInUniversity;
        this.courses = courses;
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

    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }
}

