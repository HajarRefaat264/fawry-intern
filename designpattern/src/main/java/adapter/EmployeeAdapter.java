package adapter;

public class EmployeeAdapter implements NewEmployeeSystem {
    private LegacyEmployeeSystem legacyEmployee;

    public EmployeeAdapter(LegacyEmployeeSystem legacyEmployee) {
        this.legacyEmployee = legacyEmployee;
    }

    @Override
    public void displayEmployeeDetails(String name, String designation) {
        // Adapting the legacy system's data to the new system's format
        System.out.println("Employee: " + legacyEmployee.getName() +
                ", Designation: " + legacyEmployee.getRole() +
                " (adapted to new format)");
    }
}
