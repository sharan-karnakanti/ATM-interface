import java.util.*;

class atm {
    float balance;
    int pin = 1234;
    Scanner sc = new Scanner(System.in);
    boolean exit=false;
    Map<Float, String> ministmt = new HashMap<>();

    atm() {
        System.out.println("Enter atm pin: ");

        int enteredpin = sc.nextInt();
        if (enteredpin == pin) {
            menu();
        } else {
            System.out.println("You've entered wrong pin!!!!!!!!");
            return;
        }

    }

    private void menu() {
        while (!exit) {
            System.out.println("        MENU ");
            System.out.println("1)Check A/C Balance");
            System.out.println("2)Deposite cash");
            System.out.println("3)WithDraw");
            System.out.println("4)Mini statement");
            System.out.println("5)EXIT");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposite();
                    break;
                case 3:
                    withDraw();
                    break;
                case 4:
                    miniStatement();
                    break;          
                case 5:
                    System.out.println("Thanks for using ATM!!\nCollect your ATM card");
                    exit=true;
                    break;
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        }
    }

    private void miniStatement() {
        for (Map.Entry<Float, String> m : ministmt.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

    private void withDraw() {
        System.out.print("Enter amount to withdraw(multiples of 500 only):");
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("Insufficient balance in Account");
        } else if (amount % 500 == 0) {
            ministmt.put(amount, " Amount Withdrawn!");
            System.out.println("Collect your " + amount + " $");
            balance = balance - amount;
            // checkBalance();
        } else {
            System.out.println("Kindly! Enter amount in the multiples of 500 only");
        }
    }

    private void deposite() {
        System.out.print("Enter amount to deposite(muitiples of 500 only!!):");
        float amount = sc.nextFloat();
        if (amount % 500 == 0) {
            ministmt.put(amount, " Amount Deposited!");
            balance = balance + amount;
            System.out.println("Amount sucessfully added!");
            // checkBalance();
        } else {
            System.out.println("Plz!!! Insert cash in muitiples of 500 only!!");
        }
    }

    private void checkBalance() {
        System.out.println("Available Balance = " + balance + " $\n\n");
    }
}

public class ATMmachine {
    public static void main(String[] args) {
        atm obj = new atm();
    }
}