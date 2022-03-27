import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    
    // static Customer [] customers = new Customer[2];
    ArrayList<Customer> customers = new ArrayList<Customer>();
    static Admin admin = new Admin();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int ch;
        String username, pass;
        do {
            System.out.println("\t\tWelcome to the Banking system");
            System.out.println("\t\tLog in to continue\n\t\t 1 - Admin \n\t\t 2 - User \n\t\t 3 - Quit");
            ch = input.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("\t\t<=====> Admin Panel <=====>");
                    System.out.println("Enter username:");
                    username = input.next();
                    System.out.println("Enter password:");
                    pass = input.next();
                    if(admin.login(username.toString(), pass.toString())){
                        adminMenu();
                    }else{
                        System.out.println("wrong username or password!");
                        ch = 3;
                    }
                    break;
                case 2:
                    System.out.println("\t\t<=====> User Panel <=====>");
                    System.out.println("Enter username: ");
                    username = input.next();
                    System.out.println("Enter password:");
                    pass = input.next();
                    if (admin.loginUser(username, pass)) {
                        customerMenu();
                    } else {
                        System.out.println("Wrong username or password");
                        ch = 3;
                    }
                    break;
            }
        } while (ch != 3);        
        input.close();
        if (ch == 3) {
            System.out.println("Goodbye!");
        }
    }
    public static void adminMenu() {
        Scanner input = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\t\t<=====> Admin Panel <=====>");
            System.out.println("\t\tWelcome Admin");
            System.out.println("\t\t 1 - Register New Customer \n\t\t 2 - Show Customers \n\t\t 3 - Log out");
            ch = input.nextInt();
            switch (ch) {
                case 1:
                    admin.registerCustomer();
                    break;
                case 2:
                    admin.showCustomers();
                    break;
                default:
                    break;
            } 
        } while (ch != 3);
        if (ch == 3) {
            System.out.println("Admin logged out");
        }
        // input.close();
    }
    public static void customerMenu() {
        double amount, accountNum;
        Scanner input = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\t\tWelcome " + admin.showCurrentCustomer());
            System.out.println("\t\t 1 - Show Account Details \n\t\t 2 - Deposit \n\t\t 3 - Withdraw \n\t\t 4 - Transfer \n\t\t 5 - Log out");
            ch = input.nextInt();
            switch (ch) {
                case 1:
                    admin.showDetails();
                    break;
                case 2:
                    System.out.println("Enter the amount you want to deposit: ");
                    amount = input.nextDouble();
                    admin.deposit(amount);
                    break;
                case 3:
                    System.out.println("Enter the amount you want to withdraw: ");
                    amount = input.nextDouble();
                    admin.withdraw(amount);
                    break;
                case 4:
                    System.out.println("Enter the amount you want to transfer:");
                    amount = input.nextDouble();
                    System.out.println("Enter the account Number");
                    accountNum = input.nextDouble();
                    admin.transfer(amount, accountNum);
                    break;
            } 
        } while (ch != 5);
        // input.close();
        if (ch == 5) {
            System.out.println(admin.showCurrentCustomer() + " Logged out");
        }
    }
}  