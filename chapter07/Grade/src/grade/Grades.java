package grade;

public enum Grades {   // D+, D는 생략
    APlus(4.5), A(4), BPlus(3.5), B(3), CPlus(2.5), C(2), F(0);

    public double getGrade() {
        return grade;
    }

    double grade;

    Grades(double grade) {
        this.grade = grade;
    }
}
