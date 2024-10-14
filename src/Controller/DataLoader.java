package Controller;

import Model.Course;
import Model.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataLoader {
    private static DataLoader instance;

    private final List<Course> baseCourses = new ArrayList<>();
    private final List<Course> additionalCourses = new ArrayList<>();
    private final List<Teacher> allTeachers = new ArrayList<>();

    // Private constructor to prevent instantiation from other classes
    private DataLoader() {
        loadTeachersAndCourses();
    }

    // Public method to provide access to the singleton instance
    public static DataLoader getInstance() {
        if (instance == null) {
            instance = new DataLoader();
        }
        return instance;
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
}

