package Model;

import Controller.DataLoader;
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

    public boolean doesTeacherHasAccessToThisCourse(String courseName) {
        for (Course course : courses) {
            if (course.getName().equals(courseName)) {
                return true;
            }
        }
        return false;
    }

    public boolean addCourse(Course course) {
        if (!courses.contains(course)) {
            //TODO getting an exception from here and don't know why, please help
            this.courses.add(course);

            List<Course> courses1 = DataLoader.getInstance().getAdditionalCourses();
            List<Course> courses2 = DataLoader.getInstance().getBaseCourses();

            if (courses1.contains(course)) {
                for (Course additionalCourse : courses1) {
                    if (additionalCourse.getName().equals(course.getName())) {
                        additionalCourse.setTeacher(course.getTeacher());
                        return true;
                    }
                }
            }

            if (courses2.contains(course)) {
                for (Course baseCourse : courses1) {
                    if (baseCourse.getName().equals(course.getName())) {
                        baseCourse.setTeacher(course.getTeacher());
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
