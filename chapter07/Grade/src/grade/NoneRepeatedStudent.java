package grade;

public class NoneRepeatedStudent extends Student {

    private Grades mathGrade;
    private Grades scienceGrade;
    private int mathAbsence;
    private int scienceAbsence;

    public NoneRepeatedStudent(int studentId, Grades mathGrade, Grades scienceGrade, int mathAbsence, int scienceAbsence) {
        super(studentId);
        this.mathGrade = mathGrade;
        this.scienceGrade = scienceGrade;
        this.mathAbsence = mathAbsence;
        this.scienceAbsence = scienceAbsence;
    }

    public NoneRepeatedStudent(int studentId) {
        super(studentId);
    }

    @Override
    protected Grades selectScienceGrade() {
        if (super.isFailure(scienceAbsence))
            return Grades.F;
        return scienceGrade;
    }

    @Override
    protected Grades selectMathGrade() {
        if (isFailure(mathAbsence))
            return Grades.F;
        return mathGrade;
    }
}
