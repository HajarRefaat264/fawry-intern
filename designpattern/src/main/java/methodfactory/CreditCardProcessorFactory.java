package methodfactory;

public class CreditCardProcessorFactory implements PaymentProcessorFactory {
    private String cardNumber;

    public CreditCardProcessorFactory(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new CreditCardProcessor(cardNumber);
    }
}