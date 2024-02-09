package atm;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    PriInfo pr = new PriInfo();
    Password p = new Password();

    System.out.print("AUTOMATED TELLER MACHINE\nInput pin: ");
    String enteredPin = s.next();

    int index = -1;
    for (int i = 0; i < 5; i++) {
        if (enteredPin.equals(p.getPassword(i))) {
            index = i;
            break;
        }
    }

    if (index == -1) {
        System.out.println("Wrong pin!");
        return;
    }

    boolean pinUpdated = false;

    while (true) {
        if (pinUpdated) {
            System.out.print("AUTOMATED TELLER MACHINE\nInput pin: ");
            enteredPin = s.next();

            index = -1;
            for (int i = 0; i < 5; i++) {
                if (enteredPin.equals(p.getPassword(i))) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println("Wrong pin!");
                return;
            }

            pinUpdated = false;
        }

        System.out.println("[1] BALANCE [2] WITHDRAW [3] DEPOSIT [4] Get account number [5] Change Pin [6] Soon");
        System.out.print("Enter here: ");
        int choice = s.nextInt();

            switch (choice) {
                case 1:
                    displayBalance(pr);
                    break;
                case 2:
                    withdraw(pr, s);
                    break;
                case 3:
                    deposit(pr, s);
                    break;
                case 4:
                    getAccountNumber(pr, index);
                    break;
                case 5:
                    changePin(pr, p, index, s);
                    pinUpdated = true;
                    break;
                case 6:
                    System.out.println("Soon");
                    break;
                default:
                    System.out.println("Sorry, other bank transactions are under maintenance.");
                    break;
            }

            System.out.print("Do you want another transaction? [1]y [2]n: ");
        int anotherTransaction = s.nextInt();
        if (anotherTransaction == 1) {
            continue;
        } else if (anotherTransaction == 2) {
            System.out.print("Do you want to Remove card? [1]Y [2]N: ");
            int removeCard = s.nextInt();
            if (removeCard == 1) {
                System.out.println("Get your card");
                break;
            }
        } else {
            System.out.println("Invalid Choice");
            break;
        }
    }
}

    private static void displayBalance(PriInfo priInfo) {
        System.out.println("B A L A N C E\nP R O C E S S I N G . . . . .");
        System.out.println("Current balance: " + priInfo.getBalance());
    }

    private static void withdraw(PriInfo priInfo, Scanner scanner) {
        System.out.print("W I T H D R A W\nAmount: ");
        double withdrawAmount = scanner.nextDouble();
        if (withdrawAmount > priInfo.getBalance()) {
            System.out.println("Insufficient funds!");
        } else {
            priInfo.setBalance(priInfo.getBalance() - withdrawAmount);
            System.out.println("P R O C E S S I N G . . . . .");
            System.out.println("Current balance: " + priInfo.getBalance());
        }
    }

    private static void deposit(PriInfo priInfo, Scanner scanner) {
        System.out.print("D E P O S I T\nEnter amount: ");
        double depositAmount = scanner.nextDouble();
        priInfo.setBalance(priInfo.getBalance() + depositAmount);
        System.out.println("P R O C E S S I N G . . . . .");
        System.out.println("Current balance: " + priInfo.getBalance());
    }

    private static void getAccountNumber(PriInfo priInfo, int index) {
        System.out.println("Your account number is: " + priInfo.getAccountNum(index));
        System.out.println("Your id number is: " + priInfo.getIdNum(index));
    }

    private static void changePin(PriInfo priInfo, Password password, int index, Scanner scanner) {
        System.out.print("C H A N G E  P I N \nInput Old pin: ");
        String oldPin = scanner.next();
        if (oldPin.equals(password.getPassword(index))) {
            System.out.print("Input new pin: ");
            String newPin = scanner.next();
            password.setPassword(index, newPin);
            priInfo.setPin(index, newPin); // Update the pin in PriInfo
            System.out.println("Successful");
        } else {
            System.out.println("Pin did not match");
        }
    }
}
    

