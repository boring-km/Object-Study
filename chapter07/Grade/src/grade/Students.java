package grade;

import java.util.List;
import java.util.Optional;

public class Students {
    private List<Student> students = List.of (
            new NoneRepeatedStudent(202011111, Grades.APlus, Grades.A, 1, 0),
            new NoneRepeatedStudent(201912345, Grades.B, Grades.BPlus, 0, 1),
            new NoneRepeatedStudent(201433904, Grades.BPlus, Grades.APlus, 0, 0),
            new RepeatedStudent(202054321, Grades.APlus, Grades.CPlus, 3, 4),
            new RepeatedStudent(201112345, Grades.APlus, Grades.A, 0, 0)
    );

    public Grades selectScienceGradeFor(int studentId) { // 데이터 변경으로 인해 영향을 끼치는 모든 함수를 분석해서 수정해야 한다.
        Optional<Student> optionalStudent = students.stream().filter(student -> student.getStudentId() == studentId).findFirst();
        return optionalStudent.map(Student::selectScienceGrade).orElse(null);
    }

    public Grades selectMathGradesFor(int studentId) {  // 데이터 변경으로 인해 영향을 끼치는 모든 함수를 분석해서 수정해야 한다.
        Optional<Student> optionalStudent = students.stream().filter(student -> student.getStudentId() == studentId).findFirst();
        return optionalStudent.map(Student::selectMathGrade).orElse(null);
    }

    public boolean transferFor(int studentId) {
        return students.add(new NoneRepeatedStudent(studentId));
    }
}
