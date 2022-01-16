
class Manager extends Staff{

    private double salary;
    private String position;

    public Manager(String id, String name, int age, double heSoLuong, String startDate,
                   Department department, int numDayOff, String position) {
        super(id, name, age, heSoLuong, startDate, department, numDayOff);
        this.position = position;
    } // hàm khởi tạo

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public double calculateSalary() {
        // Tính lương quản lý theo chức danh
        if(position.equalsIgnoreCase("Business Leader")){
            salary = super.getHeSoLuong() * 5000 + 8000;
        }
        if(position.equalsIgnoreCase("Project Leader")) {
            salary = super.getHeSoLuong() * 5000 + 5000;
        }
        if(position.equalsIgnoreCase("Technical Leader")) {
            salary = super.getHeSoLuong() * 5000 + 6000;
        }
        return salary;
    }

    @Override
    public void displayInformation() {
        // Hiển thị thông tin lớp quản lý
        String salary = "" + this.calculateSalary();
        System.out.format("|%5s |%15s |%5d |%12s |%12s |%10s | %20s |", super.getId(), super.getName(), super.getAge(),
                          super.getStartDate(), super.getDepartment().getDepartmentName(), salary, this.getPosition());
        System.out.println();
        System.out.println("+-----------------------------------------------------" +
                           "----------------------------------------+");
    }
}
