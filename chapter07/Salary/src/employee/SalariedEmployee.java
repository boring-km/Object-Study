package employee;

public class SalariedEmployee implements Employee {

    private final int baseSalary;
    private final String name;

    public SalariedEmployee(String name, int baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    @Override
    public boolean isEqual(String name) {
        return this.name.equals(name);
    }

    @Override
    public int calculateSalary(double taxRate) {
        return (int) (baseSalary - (baseSalary * taxRate));
    }

    @Override
    public int getMonthlySalary() {
        return baseSalary;
    }
}
