public class Department {

    private int departmentId;
    private String departmentName;
    private int numberOfEmployee;

    public Department(int departmentId, String departmentName, int numberOfEmployee) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.numberOfEmployee = numberOfEmployee;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    // phương thức toString
    public String toString(){
        return String.format("|%3s |%15s |%6s |", this.departmentId, this.departmentName, this.numberOfEmployee);
    }
}
