package grade;

import java.util.Scanner;

public class Main {

    private static Students students;

    public static void main(String[] args) {    // 사용자로부터 학번을 입력받아 학점을 조회한 후 조회된 결과를 화면에 출력한다.
        students = new Students();
        switch (args[0]) {  // 메인 함수의 구조가 변경됨
            case "selectMath":
                selectMathGrade();
                break;
            case "transfer":
                transfer(Integer.parseInt(args[1]));
                break;
            case "selectScience":
                selectScienceGrade();
            default:
                break;
        }
    }

    private static void transfer(int parseInt) {
        boolean result = students.transferFor(parseInt);
        if (result)
            System.out.println("성공적으로 편입이 처리되었습니다.");
        else
            System.out.println("편입 처리가 실패했습니다.");
    }

    private static void selectScienceGrade() {
        int studentId = inputStudentId();
        Grades scienceGrade = students.selectScienceGradeFor(studentId);  // 비즈니스 로직의 결과인 학점이
        printResult(scienceGrade);                      // 사용자 인터페이스인 출력문에 영향을 준다.
    }

    private static void selectMathGrade() {
        int studentId = inputStudentId();
        Grades mathGrade = students.selectMathGradesFor(studentId);  // 비즈니스 로직의 결과인 학점이
        printResult(mathGrade);                      // 사용자 인터페이스인 출력문에 영향을 준다.
    }

    private static int inputStudentId() {
        System.out.print("학번을 입력하세요: ");
        return new Scanner(System.in).nextInt();
    }

    private static void printResult(Grades grade) {
        System.out.println("학점: " + grade + "(" + grade.getGrade() + "점)");
    }

}