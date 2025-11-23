package co.com.buggy.test.models;

public class RegistrationData {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;

    public RegistrationData(String username, String firstName, String lastName, String password, String confirmPassword) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() { return username; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPassword() { return password; }
    public String getConfirmPassword() { return confirmPassword; }
}
