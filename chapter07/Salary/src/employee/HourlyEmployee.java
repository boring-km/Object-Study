package employee;

public class HourlyEmployee implements Employee {

    private final String name;
    private final int baseSalary;
    private final int timeCard;

    public HourlyEmployee(String name, int baseSalary, int timeCard) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.timeCard = timeCard;
    }

    @Override
    public boolean isEqual(String name) {
        return this.name.equals(name);
    }

    @Override
    public int calculateSalary(double taxRate) {
        double salaryBeforeTax = baseSalary * timeCard;
        return (int) (salaryBeforeTax - (salaryBeforeTax * taxRate));
    }

    @Override
    public int getMonthlySalary() {
        return 0;
    }
}
