import View.ConsoleView;

public class Main {
    public static void main(String[] args) {
        // Create a ConsoleView instance
        ConsoleView view = new ConsoleView();

        // Start the app with login
        view.showLogin();
        view.showMenu();
    }
}

/*
Based on the input, the UserController simulates a login
(you can use
student
password123
or
teacher
password123
as valid credentials).
*/
