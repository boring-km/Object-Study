package employee;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Employees {

    private static final Employee[] employees = new Employee[] {    // 데이터 타입이 각각의 클래스로 표현됨
            new SalariedEmployee("직원A", 7000000),
            new SalariedEmployee("직원B", 5000000),
            new SalariedEmployee("직원C", 9000000),
            new HourlyEmployee("아르바이트D", 10000, 180),
            new HourlyEmployee("아르바이트E", 9000, 120),
            new HourlyEmployee("아르바이트F", 15000, 120)
    };

    public static double calculateSalary(String name, double taxRate) {
        return getSalary(name, taxRate);
    }

    private static double getSalary(String name, double taxRate) {
        return Arrays.stream(employees).filter(employee -> employee.isEqual(name)).findFirst()
                .map(employee -> employee.calculateSalary(taxRate)).orElse(0);
    }

    public static int calculateSumOfMonthlySalary() {
        return Arrays.stream(employees).mapToInt(Employee::getMonthlySalary).sum();
    }

    public static int calculateAverageOfMonthlySalary() {
        OptionalDouble average = Arrays.stream(employees).mapToInt(Employee::getMonthlySalary).average();
        if (average.isPresent())
            return (int) average.getAsDouble();
        return 0;
    }
}
