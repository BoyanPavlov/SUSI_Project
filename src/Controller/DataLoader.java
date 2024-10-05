package Controller;

import Model.Course;
import Model.Teacher;

import java.util.Arrays;
import java.util.List;

public class DataLoader {

    public List<Teacher> loadTeachersAndCourses() {
        // Simulating fetching data from a "database"

        // Create teachers
        Teacher armyanov = new Teacher("Armyanov", "password123", null);
        Teacher velikova = new Teacher("Velikova", "password123", null);
        Teacher alexandrov = new Teacher("Alexandrov", "password123", null);

        // Create courses and assign teachers
        Course oop = new Course("OOP", "Fall 2024", "Armyanov", 30);
        Course linearAlgebra = new Course("Linear Algebra", "Fall 2024", "Velikova", 25);
        Course secondAlgebra = new Course("Second Algebra", "Summer 2025", "Velikova", 25);
        Course geometry = new Course("Geometry", "Spring 2024", "Alexandrov", 20);

        // Assign courses to each teacher
        armyanov.setCourses(Arrays.asList(oop));
        velikova.setCourses(Arrays.asList(linearAlgebra, secondAlgebra));
        alexandrov.setCourses(Arrays.asList(geometry));

        // Return a list of all teachers
        return Arrays.asList(armyanov, velikova, alexandrov);
    }
}

