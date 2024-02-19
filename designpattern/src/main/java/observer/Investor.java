package observer;

public class Investor  implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(Stock stock) {
        System.out.println("Investor " + name + " received an update: " +
                "Stock " + stock.getSymbol() + " price changed to $" + stock.getPrice());
    }
}