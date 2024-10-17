# University Course Management System

This is a simple University Course Management System built using Java. The system simulates basic functionality such as user login, viewing their courses, also all courses, logout. Users can be either students or teachers, each having specific roles and functionalities within the system.

## Features

- **User Login**: The system allows students and teachers to log in with predefined credentials.

- **Role-Based Access**:
  - **Students**: After logging in, students can view the courses they've signed up for.
  - **Teachers**: Teachers can view the courses they are teaching.
- **Course Management**: The system contains preloaded courses that are associated with teachers and students. 
  - Courses are assigned to specific teachers.
  - Students can sign up for and view courses.
  
## System Components

### 1. **Model Layer** (`model` package)
   This layer contains the data classes that represent the system's core entities.
   
   - **User** (abstract class): The base class representing a user in the system. It contains common properties like `name` and `password`.
   - **Student**: Extends the `User` class and represents a student in the system. Students can sign up for and view courses.
   - **Teacher**: Extends the `User` class and represents a teacher. Teachers can view and manage the courses they teach.
   - **Course**: Represents a course offered by the university. Each course has a name, period, teacher, and capacity.

### 2. **Controller Layer** (`controller` package)
   This layer manages the business logic and interaction between the model and view layers.
   
   - **UserController**: Handles user login and logout. It keeps track of the currently logged-in user and manages user authentication.
   - **DataLoader**: Simulates fetching data from a database. It loads a set of predefined courses and assigns them to teachers.

### 3. **View Layer** (`view` package)
   This layer is responsible for the user interface (console-based in this case).
   
   - **ConsoleView**: Displays the login screen and the post-login options (view courses, log out ...). It handles input from the user and communicates with the `UserController` to manage the flow.

## Predefined Data

### Teachers
- **Armyanov**: Teaches OOP
- **Velikova**: Teaches Linear Algebra and Second Algebra
- **Alexandrov**: Teaches Geometry
- **Geogriev**: Teaches Bridge

### Courses
- **OOP**: Fall 2024, taught by Armyanov, capacity: 30 students
- **Linear Algebra**: Fall 2024, taught by Velikova, capacity: 25 students
- **Second Algebra**: Summer 2025, taught by Velikova, capacity: 25 students
- **Geometry**: Spring 2024, taught by Alexandrov, capacity: 20 students
- **Bridge**: check by yourself ;)

### Users and Credentials
- **Student login**:
  - Username: `student`
  - Password: `password123`
- **Teacher login**:
  - Username: `teacher`
  - Password: `password123`
