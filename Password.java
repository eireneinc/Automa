package atm;

public class Password {
    private String[] passwords = {"1234", "5678", "4321", "8765", "1111"};

    public String getPassword(int index) {
        return passwords[index];
    }

    public void setPassword(int index, String newPassword) {
        passwords[index] = newPassword;
    }
}
