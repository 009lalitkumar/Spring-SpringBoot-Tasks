public class UserBean {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static UserBean getInstance() {
        return new UserBean();
    }

    @Override
    public String toString() {
        return "UserBean [first Name=" + firstName + ", last Name=" + lastName + "]";
    }

}