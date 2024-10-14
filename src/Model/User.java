package Model;

public abstract class User {
    private String name;
    private String password;
    protected String role;

    // Constructor
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Getters and Settears
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract String getRole();

    public abstract void showCourses();
}

