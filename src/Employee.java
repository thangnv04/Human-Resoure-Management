
class Employee extends Staff{

    private double overtimeHour;
    private double salary;

    public Employee(String id, String name, int age, double heSoLuong, String startDate,
                    Department department, int numDayOff, double overtimeHour) {
        super(id, name, age, heSoLuong, startDate, department, numDayOff);
        this.overtimeHour = overtimeHour;
    }

    public double getSalary() {
        return salary;
    }

    public double getOvertimeHour() {
        return overtimeHour;
    }

    public void setOvertimeHour(double overtimeHour) {
        this.overtimeHour = overtimeHour;
    }

    @Override
    public double calculateSalary() {
        // Tính lương nhân viên
        salary = getHeSoLuong() * 3000 + overtimeHour * 200;
        return salary;
    }

    @Override
    public void displayInformation() {

        // Hiển thị thông tin lớp ngân
        String salary = "" + this.calculateSalary();
        System.out.format("|%5s |%15s |%5d |%12s |%12s |%10s | %20s |", super.getId(), super.getName(), super.getAge(),
                          super.getStartDate(), super.getDepartment().getDepartmentName(), salary, " ");
        System.out.println();
        System.out.println("+-------------------------------------------------" +
                           "--------------------------------------------+");
    }
}
