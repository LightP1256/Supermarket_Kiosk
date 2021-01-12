public class adminAcc {
    // Setting variable for admin username and password
    String username;
    String password;

    public adminAcc(String logUser, String logPass) {
        this.username = logUser;
        this.password = logPass;
    }
    // Getter
    public String getUser() {
        return username;
    }
    public String getPass() {
        return password;
    }
    // Setter
    public void setUser(String adminUser) {
        username = adminUser;
    }
    public void setPass(String adminPass) {
        password = adminPass;
    }
}
