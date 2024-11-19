package SchoolManagementSystem;

public class Professor extends User {
    private String professorId;

    public Professor(String name, String dept, String ssn, String professorId) {
        super(name, dept, ssn);
        this.professorId = professorId;
    }

    public String getProfessorId() {
        return professorId;
    }

    @Override
    public String toString() {
        return super.toString() + "\n교수 번호: " + professorId;
    }
}

