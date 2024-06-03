package com.atm.simulator;

import java.util.Scanner;

public class MainApplication {

    private static AccountDAO accountDAO = new AccountDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***Welcome to ATM Simulator!***");
        while (true) {
            System.out.println("\nATM Simulator Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. View Account Details");
            System.out.println("3. Update Account");
            System.out.println("4. Delete Account");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    viewAccount(scanner);
                    break;
                case 3:
                    updateAccount(scanner);
                    break;
                case 4:
                    deleteAccount(scanner);
                    break;
                case 5:
                    viewAllAccounts();
                    break;
                case 6:
                    System.out.println("\n***Thank you for using ATM Simulator*** \n\t\tGoodbye!\n\n");
                    scanner.close();
                    HibernateUtil.shutdown();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String accountHolder = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setAccountHolder(accountHolder);
        account.setBalance(balance);

        accountDAO.saveAccount(account);
        System.out.println("\n\tAccount created successfully.");
    }

    private static void viewAccount(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int id = scanner.nextInt();
        Account account = accountDAO.getAccountById(id);
        if (account != null) {
            System.out.println("Account ID: " + account.getId());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getAccountHolder());
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void updateAccount(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Account account = accountDAO.getAccountById(id);
        if (account != null) {
            System.out.print("Enter new account number: ");
            String accountNumber = scanner.nextLine();
            System.out.print("Enter new account holder name: ");
            String accountHolder = scanner.nextLine();
            System.out.print("Enter new balance: ");
            double balance = scanner.nextDouble();

            account.setAccountNumber(accountNumber);
            account.setAccountHolder(accountHolder);
            account.setBalance(balance);

            accountDAO.updateAccount(account);
            System.out.println("\n\tAccount updated successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void deleteAccount(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int id = scanner.nextInt();
        accountDAO.deleteAccount(id);
        System.out.println("\n\tAccount deleted successfully.");
    }

    private static void viewAllAccounts() {
        for (Account account : accountDAO.getAllAccounts()) {
            System.out.println("Account ID: " + account.getId());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getAccountHolder());
            System.out.println("Balance: " + account.getBalance());
            System.out.println();
        }
    }
}
