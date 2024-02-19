package strategy;

public class PaymentClient {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Using different payment strategies
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456");
        PaymentStrategy payPalPayment = new PayPalPayment("user@example.com");
        PaymentStrategy bitcoinPayment = new BitcoinPayment("1BitcoinAddress");

        // Setting a payment strategy and checking out
        cart.setPaymentStrategy(creditCardPayment);
        cart.checkout(100.0);

        // Changing the payment strategy and checking out again
        cart.setPaymentStrategy(payPalPayment);
        cart.checkout(50.0);

        // Using a different payment strategy
        cart.setPaymentStrategy(bitcoinPayment);
        cart.checkout(75.0);
    }
}