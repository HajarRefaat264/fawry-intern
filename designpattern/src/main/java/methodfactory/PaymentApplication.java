package methodfactory;

public class PaymentApplication {
    public static void main(String[] args) {
        // Client code decides which payment method to use
        PaymentProcessorFactory creditCardFactory = new CreditCardProcessorFactory("1234-5678-9012-3456");
        PaymentProcessor creditCardProcessor = creditCardFactory.createPaymentProcessor();
        creditCardProcessor.processPayment(100.0);

        PaymentProcessorFactory paypalFactory = new PayPalProcessorFactory("user@example.com");
        PaymentProcessor paypalProcessor = paypalFactory.createPaymentProcessor();
        paypalProcessor.processPayment(50.0);
    }
}
