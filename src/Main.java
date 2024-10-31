import View.ConsoleView;

public class Main {
    public static void main(String[] args) {
        // Create a ConsoleView instance
        ConsoleView view = new ConsoleView();

        // Start the app with login
        view.showLogin();
        view.showUserInterface();
    }
}

/*
Based on the input, the UserController simulates a login
(you can use

student:
Bobby
password123
or

teacher:
Armyanov
password123
or

admin:
Addy
123
*/
