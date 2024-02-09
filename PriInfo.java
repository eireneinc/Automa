package atm;

public class PriInfo {
    private double balance = 20000.36;
    private String[] accountNums = {"125870", "789456", "996687", "225588", "335574"};
    private String[] idNums = {"SA125870", "SA789456", "SA996687", "SA225588", "SA335574"};
    private String[] pins = {"1234", "5678", "4321", "8765", "1111"};

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNum(int index) {
        return accountNums[index];
    }

    public String getIdNum(int index) {
        return idNums[index];
    }

    public String getPin(int index) {
        return pins[index];
    }

    public void setPin(int index, String pin) {
        pins[index] = pin;
    }
}
