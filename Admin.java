import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    Scanner input = new Scanner(System.in);
    int current = -1;
    double limit = 10000;
    public ArrayList<Customer> customers = new ArrayList<Customer>();

    private String username = "admin";
    private String password = "1111";

    /**
     * 
     * @param user
     * @param pass
     * @return true if the succesful else false
     */
    public boolean login(String user, String pass) {
        if (this.username.equals(user) && this.password.equals(pass)) {
            return true;
        }else{
            return false;
        }
    }

    // public String printUserPassword(int ch) {
    //     if (ch == 1) {
    //         return customers.get(current).password;
    //     } else {
    //         String Str = "";
    //         for (int i = 0; i < customers.get(current).password.length(); i++) {
    //             Str +="*";
    //         }
    //         return Str;
    //     }
    // }

    public String showCurrentCustomer() {
        return customers.get(current).name;
    }

    public void registerCustomer() {
        String name, password;
        double balance;
        int n;
        System.out.println("How many customers do you wanna register?");
        n = input.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter customer[" + (i+1) + "] name");
            name = input.next();
            System.out.println("Enter customer[" + (i+1) + "] password");
            password = input.next();
            System.out.println("Enter customer[" + (i+1) + "] initial balance");
            balance = input.nextDouble();
            Customer customer = new Customer(name, password, balance);
            this.customers.add(customer);
        }
    }
    /**
     * print out the objects in the arraylist
     * @return void
     */
    public void showCustomers() {
        System.out.println("Username: \t" + "Password: \t" + "Account-Number: \t" + "Balance:");
        try {
            for (Customer customer : this.customers) {
                System.out.println(customer.name + " \t\t"+ customer.password +" \t\t"+ customer.accountNumber +" \t\t" + customer.balance);
            }
        } catch (Exception nullPException ) {
            System.out.println("Customers array is empty");     
            System.out.println("Register some customers first!");     
        }
    }
    /**
     * @param username
     * @param password
     * @return a boolean and set the current variable to the index of the customer if found
     * else the initial index is -1
     */
    public boolean loginUser(String username, String password) {
        for (Customer customer : this.customers) {
            if (customer.name.equals(username) && customer.password.equals(password)){
                current = customers.indexOf(customer);
                return true;
            }
        }
        return false;
    }

    public void showDetails() {
        System.out.println("This is your details: ");
        System.out.println("Name: " + customers.get(current).name + "\tBalance: " + customers.get(current).balance + "\tAccount Number: " + customers.get(current).accountNumber);
    }

    public void deposit(double amount) {
        if (current == -1) {
            System.out.println("Pls, Log in...");
        } else {
            this.customers.get(this.current).deposit(amount);
            this.customers.get(this.current).showBalance();
        }
    }

    public void withdraw(double amount) {
        if (current == -1) {
            System.out.println("Pls, Log in...");
        } else {
            this.customers.get(this.current).withdraw(amount);
        }
    }

    /**
     * 
     * @Return - pos if found else return -1
     */
    public int checkUser(double accountNumber){
        int pos = -1;
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).accountNumber == accountNumber) {
                pos = i;
            }
        }
        return pos;
    }

    public void transfer(double amount, double accountNumber) {
        int check =this.checkUser(accountNumber);
        if (check == -1) {
            System.out.println("Account number not found!");
        }else {
            this.customers.get(this.current).transfer(amount, accountNumber);
            this.customers.get(check).deposit(amount);
        }

    }

}