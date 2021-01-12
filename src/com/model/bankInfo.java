public class bankInfo {
    private String accountName;
    private int age;
    private float accountBalance;
    private  boolean activeAccount;
    // Getters
    public String getAccountName() {
        return accountName;
    }
    public int getAge() {
        return age;
    }
    public float getAccountBalance() {
        return accountBalance;
    }
    public boolean activeAccount() {
        return activeAccount;
    }
    // Setters
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public void  setAge(int age) {
        this.age = age;
    }
    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }
    public void setActiveAccount(boolean activeAccount) {
        this.activeAccount = activeAccount;
    }
}
