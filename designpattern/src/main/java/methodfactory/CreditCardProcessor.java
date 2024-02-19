package methodfactory;

public class CreditCardProcessor implements PaymentProcessor {
    private String cardNumber;

    public CreditCardProcessor(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount + " with card number " + cardNumber);
        // Actual credit card processing logic would go here
    }}