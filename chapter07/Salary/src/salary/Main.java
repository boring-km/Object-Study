package salary;

import employee.Employees;

import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) throws IllegalAccessException {
        scanner = new Scanner(System.in);

        System.out.println("#1: 특정 직원의 급여를 계산");
        System.out.println("#2: 모든 직원들의 기본급 총합 계산");
        System.out.println("#3: 모든 직원들의 기본급 평균 계산");
        System.out.print("원하는 업무의 번호(숫자)를 입력 : ");
        int operation = scanner.nextInt();

        switch (operation) {
            case 1:
                calculateSalary();
                break;
            case 2:
                calculateSumOfBaseSalary();
                break;
            case 3:
                calculateAverageOfBaseSalary();
                break;
            default:
                throw new IllegalAccessException("입력 가능한 업무 번호는 1~3 까지임");
        }
    }

    private static String scanEmployee() {
        System.out.print("직원명을 입력하세요: ");
        return scanner.next();
    }

    private static double scanTaxRate() {
        System.out.print("\n세율을 입력하세요: ");
        return scanner.nextDouble();
    }

    private static void calculateSalary() {
        String name = scanEmployee();
        double taxRate = scanTaxRate();
        double salary = Employees.calculateSalary(name, taxRate);
        System.out.println("이름: " + name + "\n급여: " + salary);
    }

    private static void calculateSumOfBaseSalary() {
        int sumOfBaseSalary = Employees.calculateSumOfMonthlySalary();
        System.out.println("모든 직원들의 기본급 총합: " + sumOfBaseSalary);   // 사용자 인터페이스 로직
    }

    private static void calculateAverageOfBaseSalary() {
        int average = Employees.calculateAverageOfMonthlySalary();
        System.out.println("모든 직원들의 기본급 평균: " + average);   // 사용자 인터페이스 로직
    }
}
