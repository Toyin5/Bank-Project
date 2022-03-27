import java.security.SecureRandom;

/**
 * Customer
 */
public class Customer {
    String name;
    String password;
    double accountNumber;
    double balance;
    double limit = 10000;
    SecureRandom rand = new SecureRandom();
    int minRange = 10000, maxRange= 90000;
    // Customer cus = new Customer(name, password, 10000);

    Customer(String name, String password, double balance){
        this.name = name;
        // generate a random number between 10000 and 90000
        this.accountNumber = rand.nextInt(maxRange - minRange) + minRange;
        this.balance = balance;
        this.password = password;
    }

    public void showBalance(){
        System.out.println("Your current balance is: " + this.balance + " SDG");
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient Funds. You can withdraw more than your savings");
            this.showBalance();
        }else{
            this.balance-=amount;
            this.showBalance();
        }
    }

    public void deposit(double amount) {
        if (amount > limit) {
            System.out.println("Amount above limit");
        } else {
            this.balance+=amount;
            // this.showBalance();
        }
    }
    
    public void transfer(double amount, double accountNumber) {
        System.out.println("Transferring " + amount + " to " + accountNumber);
        this.balance-=amount;
        this.showBalance();
    }
}
