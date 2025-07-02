import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class BankAccount {
    //attributs
    private double balance;
    private List<Transaction> transactions;
//construc
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }
//getter of balance
    public double getBalance() {
        return balance;
    }
//déposer
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be strictly positive.");
            return false;
        }
        balance += amount;
        logTransaction("Deposit", amount);
        return true;
    }
//ejbd
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= amount;
        logTransaction("Withdraw", amount);
        return true;
    }
// logs
    private void logTransaction(String type, double amount) {
        Transaction transaction = new Transaction(type, amount, LocalDateTime.now(), balance);
        transactions.add(transaction);
        try (FileWriter fw = new FileWriter("transactions.log", true)) {
            fw.write(transaction.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing transaction log: " + e.getMessage());
        }
    }
//atb3
    public void printTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
