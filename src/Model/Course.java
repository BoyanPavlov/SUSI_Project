package Model;

import java.util.List;

public class Course {
    private String name;
    private String period;
    private String teacherName;
    private int capacity;
    private List<Student> enrolledStudents;

    public Course(String name, String period, String teacher, int capacity) {
        this.name = name;
        this.period = period;
        this.teacherName = teacher;
        this.capacity = capacity;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTeacher() {
        return teacherName;
    }

    public void setTeacher(String teacher) {
        this.teacherName = teacher;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}

