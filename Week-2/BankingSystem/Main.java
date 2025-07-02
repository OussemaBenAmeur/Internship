public class Main {
    public static void main(String[] args) {
        Customer ali = new Customer("Ali", 500.0);
        Customer beji = new Customer("Beji", 700.0);

        System.out.println("Current balance: " + ali.getAccount().getBalance());
        ali.getAccount().deposit(200);
        ali.getAccount().withdraw(100);
        ali.getAccount().withdraw(700);
        ali.getAccount().printTransactions();

        System.out.println("Current balance: " + ali.getAccount().getBalance());
        beji.getAccount().deposit(200);
        beji.getAccount().withdraw(100);
        beji.getAccount().withdraw(700);
        beji.getAccount().printTransactions();
    }
}
