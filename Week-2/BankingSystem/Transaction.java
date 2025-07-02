import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    //les attributs
    private String type;
    private double amount;
    private LocalDateTime dateTime;
    private double balanceAfter;
//construct
    public Transaction(String type, double amount, LocalDateTime dateTime, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.dateTime = dateTime;
        this.balanceAfter = balanceAfter;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %.2f | Balance: %.2f",
                dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                type, amount, balanceAfter);
    }
}
