package adapter;

public class LegacyEmployeeSystem {
    private String employeeName;
    private String employeeRole;

    public LegacyEmployeeSystem(String name, String role) {
        this.employeeName = name;
        this.employeeRole = role;
    }

    public String getName() {
        return employeeName;
    }

    public String getRole() {
        return employeeRole;
    }
}