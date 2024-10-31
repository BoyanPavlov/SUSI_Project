package Model;

import Controller.DataLoader;
import Model.common.StringResources;

import java.util.Objects;

public class Admin extends User {

    public Admin(String name, String password) {
        super(name, password);
        this.role = StringResources.ADMIN;
    }

    @Override
    public String getRole() {
        return this.role;
    }

    public void createUser(String username, String password, String role) {

        if (Objects.equals(role, StringResources.ADMIN)) {
            DataLoader.getInstance().addAdmin(new Admin(username, password));

        } else if (Objects.equals(role, StringResources.STUDENT)) {
            DataLoader.getInstance().addStudent(new Student(username, password,
                    DataLoader.getInstance().generateFn(),
                    "Group B", 3, null));

        } else {
            DataLoader.getInstance().addTeacher(new Teacher(username, password, null));
        }

    }

    public void addCourse(String courseName) {
        Course courseToBeAdded = new Course(courseName, "Summer 2025", StringResources.UNKNOWN, 30);

        DataLoader.getInstance().addAdditionalCourse(courseToBeAdded);
        DataLoader.getInstance().SignTeacherToACourse(courseName, StringResources.UNKNOWN);
    }

    public void addGradeToStudent(String studentName, String courseName, int grade) {
        Student student = DataLoader.getInstance().getStudent(studentName);
        if (student != null) {
            student.changeGrade(courseName, grade);
        }
    }

    public void markStudentAsPassed(String studentName, String courseName) {
        Student student = DataLoader.getInstance().getStudent(studentName);
        if (student != null) {
            int grade = student.getGradeAtCourse(courseName);
            if (grade <= 2) {
                student.changeGrade(courseName, 3);
            }
        }
    }


}
