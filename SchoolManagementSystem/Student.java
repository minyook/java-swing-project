package SchoolManagementSystem;

public class Student extends User {
    private String studentId;

    public Student(String name, String dept, String ssn, String studentId) {
        super(name, dept, ssn);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return super.toString() + "\n학번: " + studentId;
    }
}

