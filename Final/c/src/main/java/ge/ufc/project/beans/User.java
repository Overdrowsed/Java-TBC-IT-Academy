package ge.ufc.project.beans;

public class User {
    private String fullName;
    private float balance;
    
    public User(String fullName, float balance) {
        this.fullName = fullName;
        this.balance = balance;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User [fullName=" + fullName + ", balance=" + balance + "]";
    }
}
