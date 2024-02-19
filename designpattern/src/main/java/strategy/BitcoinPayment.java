package strategy;

public class BitcoinPayment implements PaymentStrategy {
    private String bitcoinAddress;

    public BitcoinPayment(String bitcoinAddress) {
        this.bitcoinAddress = bitcoinAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing Bitcoin payment of $" + amount + " to address " + bitcoinAddress);
        // Actual Bitcoin processing logic would go here
    }
}

