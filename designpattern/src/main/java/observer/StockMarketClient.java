package observer;

public class StockMarketClient {
    public static void main(String[] args) {
        // Creating a stock and investors
        Stock appleStock = new Stock("AAPL", 150.0);
        Investor investor1 = new Investor("John");
        Investor investor2 = new Investor("Alice");

        // Adding investors as observers to the stock
        appleStock.addObserver(investor1);
        appleStock.addObserver(investor2);

        // Simulating stock price changes
        appleStock.setPrice(155.0);
        appleStock.setPrice(160.0);

        // Removing an investor
        appleStock.removeObserver(investor1);

        // Simulating more stock price changes
        appleStock.setPrice(158.0);
        appleStock.setPrice(165.0);
    }
}
