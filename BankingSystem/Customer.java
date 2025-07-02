public class Customer {
    //attributs
    private String name;
    private BankAccount account;
//construct
    public Customer(String name, double initialBalance) {
        this.name = name;
        this.account = new BankAccount(initialBalance);
    }
//getter of name
    public String getName() {
        return name;
    }
//getter of bank acc
    public BankAccount getAccount() {
        return account;
    }
}
