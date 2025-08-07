package in.ac.adit.erp.model;

/**
 * The Employee class represents an employee entity containing
 * both login credentials and personal profile information.
 */
public class Employee {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String mobileno;
    private String designation;
    private String gender;

    /**
     * Gets the username.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     * @param username The employee's username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * @param password The employee's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Returns a string representation of the Employee object.
     * @return A string containing employee details.
     */
    @Override
    public String toString() {
        return "Employee [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname="
                + lastname + ", email=" + email + ", mobileno=" + mobileno + ", designation=" + designation
                + ", gender=" + gender + "]";
    }
}
