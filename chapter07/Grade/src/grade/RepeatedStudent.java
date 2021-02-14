package grade;

public class RepeatedStudent extends Student{
    private final Grades mathGrade;
    private final Grades scienceGrade;
    private final int mathAbsence;
    private final int scienceAbsence;

    public RepeatedStudent(int studentId, Grades mathGrade, Grades scienceGrade, int mathAbsence, int scienceAbsence) {
        super(studentId);
        this.mathGrade = mathGrade;
        this.scienceGrade = scienceGrade;
        this.mathAbsence = mathAbsence;
        this.scienceAbsence = scienceAbsence;
    }

    @Override
    protected Grades selectScienceGrade() {
        if (super.isFailure(scienceAbsence))
            return Grades.F;
        return processForRepeatedStudent(scienceGrade);
    }

    @Override
    protected Grades selectMathGrade() {
        if (isFailure(mathAbsence))
            return Grades.F;
        return processForRepeatedStudent(mathGrade);
    }

    private Grades processForRepeatedStudent(Grades grade) {
        if (grade.equals(Grades.APlus) || grade.equals(Grades.A))
            return Grades.BPlus;
        return grade;
    }
}
