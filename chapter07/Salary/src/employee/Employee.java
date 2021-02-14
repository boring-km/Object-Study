package employee;

public interface Employee {

    boolean isEqual(String name);
    int calculateSalary(double taxRate);
    int getMonthlySalary();
}
