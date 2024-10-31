package Model;

import Controller.DataLoader;
import Model.common.StringResources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends User {
    private String facultyNumber;
    private String group;
    private int yearInUniversity;
    private List<Course> courses;
    private Map<String, Integer> grades = new HashMap<>();

    public Student(String name, String password, String facultyNumber
            , String group, int yearInUniversity, List<Course> courses) {
        super(name, password);
        this.facultyNumber = facultyNumber;
        this.group = group;
        this.yearInUniversity = yearInUniversity;
        this.courses = courses;
        this.role = StringResources.STUDENT;

        loadGrades(courses);
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

    public int getGradeAtCourse(String courseName) {
        Integer grade = grades.get(courseName);
        if (grade != null) {
            return grade;
        }
        return -1;
    }

    public void changeGrade(String courseName, int newGrade) {
        if (grades.containsKey(courseName)) {

            grades.put(courseName, newGrade);
            System.out.println("Grade updated for course: " + courseName);

        } else {
            System.out.println("Course not found: " + courseName);
        }
    }

    public void showCourses() {
        System.out.println("\nCourses of a student with FN: " + facultyNumber + " are:\n");

        if (courses != null && !courses.isEmpty()) {
            for (Course course : courses) {
                Integer grade = grades.get(course.getName());
                System.out.println(course.getName() + " - " + course.getTeacher() +
                        " (" + course.getPeriod() + " - " + "Grade: " + (grade != null ? grade : "N/A") + ")");
            }
        } else {
            System.out.println("You don't have any courses.");
        }
    }

    public void showAdditionalCourses() {
        List<Course> additionalCourses = DataLoader.getInstance().getBaseCourses();
        for (Course course : additionalCourses) {
            System.out.println(course.getName() + " - " + course.getTeacher() +
                    " (" + course.getPeriod() + ")");
        }
    }

    @Override
    public String getRole() {
        return this.role;
    }

    public void addCourse(Course course) {

        if (!courses.contains(course)) {
            this.courses.add(course);
            this.grades.put(course.getName(), -1);
        }
    }

    private void loadGrades(List<Course> courses) {
        for (Course course : courses) {
            grades.put(course.getName(), -1);
        }
    }
}

