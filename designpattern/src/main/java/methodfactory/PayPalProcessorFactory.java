package methodfactory;

public class PayPalProcessorFactory implements PaymentProcessorFactory {
    private String email;

    public PayPalProcessorFactory(String email) {
        this.email = email;
    }

    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new PayPalProcessor(email);
    }
}