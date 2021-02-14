package grade;

public abstract class Student {

    private final int studentId;

    public Student(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    protected abstract Grades selectScienceGrade();

    protected abstract Grades selectMathGrade();

    protected boolean isFailure(int numOfAbsences) {
        return numOfAbsences >= 4;
    }

}
