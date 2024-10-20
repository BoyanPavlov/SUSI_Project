package Controller;

import Model.Admin;
import Model.Course;
import Model.Student;
import Model.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataLoader {
    private static int fnNumber = 100;
    private static DataLoader instance;

    private final List<Course> baseCourses = new ArrayList<>();
    private final List<Course> additionalCourses = new ArrayList<>();
    private final List<Teacher> allTeachers = new ArrayList<>();
    private final List<Student> allStudents = new ArrayList<>();
    private final List<Admin> allAdmins = new ArrayList<>();

    // Private constructor to prevent instantiation from other classes
    private DataLoader() {
        loadTeachersAndCourses();
        loadAdmins();
        loadStudents();
    }

    // Public method to provide access to the singleton instance
    public static DataLoader getInstance() {
        if (instance == null) {
            instance = new DataLoader();
        }
        return instance;
    }

    public void addTeacher(Teacher teacher) {
        allTeachers.add(teacher);
    }

    public void addStudent(Student student) {
        allStudents.add(student);
    }

    public void addAdditionalCourse(Course course) {
        additionalCourses.add(course);
    }

    public void addAdmin(Admin admin) {
        allAdmins.add(admin);
    }

    public void loadStudents() {
        Student student1 = new Student("Bobby", "password123", generateFn(), "Group A", 2, baseCourses);
        Student student2 = new Student("Gogo", "password124", generateFn(), "Group B", 3, baseCourses);

        allStudents.add(student1);
        allStudents.add(student2);
    }

    public void loadAdmins() {
        Admin admin1 = new Admin("Addy", "123");

        allAdmins.add(admin1);
    }

    public void loadTeachersAndCourses() {
        // Simulating fetching data from a "database"

        // Create courses and assign teachers
        Course oop = new Course("OOP", "Fall 2024", "Armyanov", 30);
        Course linearAlgebra = new Course("Linear Algebra", "Fall 2024", "Velikova", 25);
        Course secondAlgebra = new Course("Second Algebra", "Summer 2025", "Velikova", 25);
        Course geometry = new Course("Geometry", "Spring 2024", "Alexandrov", 20);
        Course bridge = new Course("Bridge", "Summer 2025", "Georgiev", 20);

        // Create teachers
        Teacher armyanov = new Teacher("Armyanov", "password123", null);
        Teacher velikova = new Teacher("Velikova", "password123", null);
        Teacher alexandrov = new Teacher("Alexandrov", "password123", null);
        Teacher geogriev = new Teacher("Georgiev", "password123", null);
        Teacher unknown = new Teacher("Unknown", "unknown", null);

        // Assign courses to each teacher
        armyanov.setCourses(Arrays.asList(oop));
        velikova.setCourses(Arrays.asList(linearAlgebra, secondAlgebra));
        alexandrov.setCourses(Arrays.asList(geometry));
        geogriev.setCourses(Arrays.asList(bridge));

        baseCourses.add(oop);
        baseCourses.add(linearAlgebra);
        baseCourses.add(secondAlgebra);
        baseCourses.add(geometry);

        additionalCourses.add(bridge);

        allTeachers.add(armyanov);
        allTeachers.add(velikova);
        allTeachers.add(geogriev);
        allTeachers.add(alexandrov);

        allTeachers.add(unknown);
    }

    public List<Course> getBaseCourses() {
        return baseCourses;
    }

    public List<Course> getAdditionalCourses() {
        return additionalCourses;
    }

    public List<Teacher> getAllTeachers() {
        return allTeachers;
    }

    public List<Student> getAllStudents() {
        return allStudents;
    }

    public List<Admin> getAllAdmins() {
        return allAdmins;
    }

    public Student getStudent(String userName) {
        for (Student student : allStudents) {
            if (student.getName().equals(userName)) {
                return student;
            }
        }
        return null;
    }

    public String generateFn() {
        return "FN" + (++fnNumber);
    }


    public Course getBaseCourse(String courseName) {
        Course course = null;
        for (Course c : baseCourses) {
            if (c.getName().equals(courseName)) {
                course = c;
            }
        }
        return course;
    }

    public Course getAdditionalCourse(String courseName) {
        Course course = null;
        for (Course c : additionalCourses) {
            if (c.getName().equals(courseName)) {
                course = c;
            }
        }
        return course;
    }

    public void SignTeacherToACourse(String courseName, String teacherName) {
        Course course = getAdditionalCourse(courseName);

        if (course != null) {

            for (Teacher teacher : allTeachers) {
                if (teacher.getName().equals(teacherName)) {
                    teacher.addCourse(course);
                }
            }
        }
    }

    public Teacher getTeacher(String teacherName) {
        for (Teacher teacher : allTeachers) {
            if (teacher.getName().equals(teacherName)) {
                return teacher;
            }
        }
        return null;
    }
}

