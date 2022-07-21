package model;

public class Staff {

    private final String username;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String userType;

    public Staff(String username, String email, String firstName, String lastName, String userType) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getUserType() {
        return userType;
    }
}
