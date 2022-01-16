abstract class Staff implements ICalculator{

    // khởi tạo các tham số
    private String id;
    private String name;
    private int age;
    private  double heSoLuong;
    private String startDate;
    private Department department;
    private int numDayOff;

    public Staff() {
        // hàm tạo không tham số
    }

    public Staff(String id, String name, int age, double heSoLuong, String startDate,
                 Department department, int numDayOff) {
        // hàm tạo có tham  số
        this.id = id;
        this.name = name;
        this.age = age;
        this.heSoLuong = heSoLuong;
        this.startDate = startDate;
        this.department = department;
        this.numDayOff = numDayOff;
    }
    // thiết lập các seter/geter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getNumDayOff() {
        return numDayOff;
    }

    public void setNumDayOff(int numDayOff) {
        this.numDayOff = numDayOff;
    }

    public abstract  double calculateSalary();

    public abstract void displayInformation();
}
