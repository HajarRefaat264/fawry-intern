package adapter;

public class EmployeeClient {
    public static void main(String[] args) {
        // Using the adapter to make the legacy system compatible with the new system
        LegacyEmployeeSystem legacyEmployee = new LegacyEmployeeSystem("Jane Smith", "Manager");
        NewEmployeeSystem adapter = new EmployeeAdapter(legacyEmployee);
        adapter.displayEmployeeDetails("Jane Smith", "Manager");
    }
}