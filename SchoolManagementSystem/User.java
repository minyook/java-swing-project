package SchoolManagementSystem;

public abstract class User {
    private String name;
    private String dept;
    private String ssn;

    public User(String name, String dept, String ssn) {
        this.name = name;
        this.dept = dept;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "이름: " + name + "\n학과: " + dept + "\n주민번호: " + ssn;
    }
}

