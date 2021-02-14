package university;

import java.util.Arrays;
import java.util.List;

public class Students {
    private static final List<Integer> studentIds = Arrays.asList(202011111, 201912345, 201433904, 202054321, 199901234, 202090002, 202090002, 202090003);
    private static final Grades[] mathGrades = new Grades[]{Grades.APlus, Grades.B, Grades.BPlus, Grades.APlus, Grades.C, Grades.APlus, Grades.BPlus, Grades.APlus};
    private static final Grades[] scienceGrades = new Grades[]{Grades.A, Grades.BPlus, Grades.APlus, Grades.APlus, Grades.CPlus, Grades.APlus, Grades.B, Grades.A};
    private static final int[] mathAbsences = new int[]{1, 0, 0, 4, 3, 0, 1, 2};
    private static final int[] scienceAbsences = new int[]{0, 1, 5, 0, 1, 2, 3, 1};
    private static final boolean[] repeats = new boolean[]{false, false, false, false, false, true, true, true};

    public static Grades selectScienceGradeFor(int studentId) { // 데이터 변경으로 인해 영향을 끼치는 모든 함수를 분석해서 수정해야 한다.
        int index = studentIds.indexOf(studentId);
        if (isFailure(scienceAbsences[index]))
            return Grades.F;
        if (isRepeatedStudent(index))
            return processForRepeatedStudent(scienceGrades[index]);
        return scienceGrades[index];
    }

    public static Grades selectMathGradesFor(int studentId) {  // 데이터 변경으로 인해 영향을 끼치는 모든 함수를 분석해서 수정해야 한다.
        int index = studentIds.indexOf(studentId);
        if (isFailure(mathAbsences[index]))
            return Grades.F;
        if (isRepeatedStudent(index))
            return processForRepeatedStudent(mathGrades[index]);
        return mathGrades[index];
    }

    private static boolean isFailure(int numOfAbsences) {
        return numOfAbsences >= 4;
    }

    private static Grades processForRepeatedStudent(Grades grade) {
        if (grade.equals(Grades.APlus) || grade.equals(Grades.A))
            return Grades.BPlus;
        return grade;
    }

    private static boolean isRepeatedStudent(int index) {
        return repeats[index];
    }

    public static void transferFor(int studentId) {
        studentIds.add(studentId);
    }
}
