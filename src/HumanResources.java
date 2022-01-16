
import org.w3c.dom.ls.LSOutput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HumanResources {

    public static void main(String[] args) {

        // khởi tạo ArrayList
        ArrayList<Staff> staffs = new ArrayList<>();
        ArrayList<Department> departments = new ArrayList<>();

        // Khởi tạo giá trị thêm vào ArrayList departments
        Department it = new Department(1, "IT", 2);
        Department marketing = new Department(2, "Marketing", 1);
        Department hr = new Department(3, "HR", 1);
        departments.add(it);
        departments.add(marketing);
        departments.add(hr);

        Staff emp1 = new Employee("em1", "Hoang", 20, 400, "22/2/2002", it,
                10, 20);
        Staff emp2 = new Employee("em1", "Hoa", 18, 350, "12/4/2014", hr,
                9, 10);
        Staff st1 = new Manager("st1", "Thom", 22, 500, "05/06/2008", marketing,
                11, "Project Leader");
        Staff st2 = new Manager("st2", "Ngat", 26, 700, "22/2/2005", it,
                14, "Business Leader");
        staffs.add(emp1);
        staffs.add(emp2);
        staffs.add(st1);
        staffs.add(st2);
        // Khởi tạo đối tượng HumanResource
        HumanResources hrs = new HumanResources();

        // Tạo menu và các tùy chọn
        hrs.Menu();
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("> Mời bạn chọn: ");
            int choise = scan.nextInt();
            switch (choise) {
                case 1:
                    System.out.println("Danh sách nhân viên:");
                    hrs.showStaffs(staffs);
                    break;
                case 2:
                    System.out.println("Danh sách bộ phận:");
                    hrs.showDept(departments);
                    break;
                case 3:
                    System.out.println("Hiển thị nhân viên theo bộ phận:");
                    hrs.showStaffDept(staffs);
                    break;
                case 4:
                    System.out.println("Thêm nhân viên mới:");
                    hrs.addStaff(staffs, departments, scan);
                    break;
                case 5:
                    System.out.println("Tìm kiếm nhân viên theo tên hoặc ID:");
                    hrs.searchStaff(staffs, scan);
                    break;
                case 6:
                    System.out.println("Hiển thị bảng lương nhân viên toàn công ty:");
                    hrs.showSalary(staffs);
                    break;
                case 7:
                    System.out.println("Hiển thị bảng lương theo thứ tự tăng dần:");
                    hrs.salaryAscending(staffs);
                    break;
                case 0:
                    System.out.println("Thoát chương trình...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bạn chọn sai! Mời chọn lại!");
                    System.out.println("---------------------------");
                    break;
            }
        } while (true);
    }

    // menu
    public void Menu() {

        System.out.println("+============================================================+");
        System.out.println("|                      HUMAN RESOURCES                       |");
        System.out.println("+============================================================+");
        System.out.println("| 1. Hiển thị danh sách nhân viên hiện có trong công ty.     |");
        System.out.println("| 2. Hiển thị các bộ phận trong công ty.                     |");
        System.out.println("| 3. Hiển thị các nhân viên theo từng bộ phận                |");
        System.out.println("| 4. Thêm nhân viên mới vào công ty.                         |");
        System.out.println("| 5. Tìm kiếm nhân viên theo tên hoặc mã nhân viên.          |");
        System.out.println("| 6. Hiển thị bảng lương của nhân viên toàn công ty.         |");
        System.out.println("| 7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần. |");
        System.out.println("| 0. Thoát chương trình                                      |");
        System.out.println("+============================================================+");
    }

    // 1 Hiển thị danh sách nhân viên trong công ty
    public void showStaffs(ArrayList<Staff> staffs) {
        if (staffs.isEmpty()) {
            // In thông báo nếu danh sách rỗng
            System.out.println("Danh sách rỗng!");
        } else {
            System.out.println("+------------------------------------------------------" +
                    "---------------------------------------+");
            System.out.format("|%5s |%15s |%5s |%12s |%12s |%10s | %20s |", "ID", "Name", "Age",
                    "Start Date", "Department", "Salary", "Position");
            System.out.println();
            System.out.println("+------------------------------------------------------" +
                    "---------------------------------------+");
            for (Staff st : staffs) {
                if (st instanceof Manager) { // Kiểm tra st có phải là thể hiện của Manager
                    ((Manager) st).displayInformation();
                } else if (st instanceof Employee) {
                    ((Employee) st).displayInformation();
                }
            }
        }
    }

    // 2 Hiển thị các bộ phận trong công ty
    public void showDept(ArrayList<Department> departments) {
        System.out.println("+-----------------------------+");
        System.out.format("|%3s |%15s |%7s|", "ID", "Department Name", "Numbers");
        System.out.println();
        System.out.println("+-----------------------------+");
        for (Department dept : departments) {
            System.out.println(dept);
            System.out.println("+-----------------------------+");
        }
    }

    // 3 Hiển thị các nhân viên theo từng bộ phận
    public void showStaffDept(ArrayList<Staff> staffs) {

        if (staffs.isEmpty()) {
            // In thông báo nếu danh sách rỗng
            System.out.println("Danh sách rỗng!");
        } else {
            System.out.println("+------------------------------------------------------" +
                    "---------------------------------------+");
            System.out.format("|%5s |%15s |%5s |%12s |%12s |%10s | %20s |", "ID", "Name", "Age",
                    "Start Date", "Department", "Salary", "Position");
            System.out.println();
            System.out.println("+------------------------------------------------------" +
                    "---------------------------------------+");
            //staffs.sort(Comparator.comparingInt(a -> (a.getDepartment().getDepartmentId())));
            Collections.sort(staffs, (a, b) -> a.getDepartment().getDepartmentName().compareTo(b.getDepartment().getDepartmentName()));
            for (Staff st : staffs) {
                if (st instanceof Manager) {
                    ((Manager) st).displayInformation();
                } else if (st instanceof Employee) {
                    ((Employee) st).displayInformation();
                }
            }
        }
    }

    // 4 Thên nhân viên mới
    public void addStaff(ArrayList<Staff> staffs, ArrayList<Department> departments, Scanner sc) {

        System.out.println("1. Thêm nhân viên thông thường.");
        System.out.println("2. Thêm nhân viên quản lý.");
        System.out.print("> ");
        int chon = sc.nextInt();
        sc.nextLine();

        if (chon == 1) {
            System.out.println("Thêm nhân viên thông thường.");
            String id;
            if(staffs.isEmpty()) {
                // Nhập ID nếu danh sách rỗng
                System.out.println("Nhập ID: ");
                id = sc.nextLine();
            } else {
                // Kiểm tra id nhập vào có trùng với id trong list
                boolean dk = true;
                do {
                    System.out.println("Nhập ID: ");
                    id = sc.nextLine();
                    for (Staff staff : staffs) {
                        if (staff.getId().equalsIgnoreCase(id)) {
                            System.out.println("ID đã tồn tại.");
                            break;
                        } else {
                            dk = false;
                        }
                    }
                } while (dk);
            }
            System.out.println("Nhập tên: ");
            String name = sc.nextLine();
            System.out.println("Nhập tuổi: ");
            int age = sc.nextInt();
            System.out.println("Nhập hệ số lương: ");
            double heSoLuong = sc.nextDouble();
            sc.nextLine();
            String startDate;
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            // Khởi tạo đối tượng SimpleDateFormat để kiểm tra định dang ngày tháng
            boolean validDate = true;
            do {
                System.out.println("Nhập ngày vào làm (dd/MM/yyyy): ");
                startDate = sc.nextLine();
                df.setLenient(false); // set false de kiem tra tinh hop le cua Date
                try {
                    df.parse(startDate); // chuyen startDate thanh kieu Date
                    validDate = false;
                }
                catch (ParseException e) { // bao loi neu startDate khong hop le
                    System.out.println("Bạn nhập sai ngày!");
                }
            } while(validDate);
            System.out.println("Bộ phận (1. IT, 2. Marketing, 3. HR): ");
            int chon1 = sc.nextInt();
            Department department = null; // Khởi tạo đối tượng department
            do {
                switch (chon1) {
                    case 1:
                        department = departments.get(0);
                        department.setNumberOfEmployee(department.getNumberOfEmployee() + 1);
                        break;
                    case 2:
                        department = departments.get(1);
                        department.setNumberOfEmployee(department.getNumberOfEmployee() + 1);
                        break;
                    case 3:
                        department = departments.get(2);
                        department.setNumberOfEmployee(department.getNumberOfEmployee() + 1);
                        break;
                    default:
                        System.out.println("Không có bộ phận bạn chọn.");
                }
            } while (chon1 < 1 || chon1 > 3);
            System.out.println("Số ngày nghỉ: ");
            int numDayOff = sc.nextInt();
            System.out.println("Giờ làm thêm:");
            int overtimeHour = sc.nextInt();
            Staff emp = new Employee(id, name, age, heSoLuong, startDate, department, numDayOff, overtimeHour);
            staffs.add(emp); // Thêm vào list staffs
        } else if (chon == 2) {
            System.out.println("Thêm nhân viên quản lý.");
            String id;
            if(staffs.isEmpty()) {
                // Nhập id nếu danh sách rỗng
                System.out.println("Nhập ID: ");
                id = sc.nextLine();
            } else {
                // kiểm tra id nhập vào có trùng với id có trong danh sách
                boolean dk = true;
                do {
                    System.out.println("Nhập ID: ");
                    id = sc.nextLine();
                    for (Staff staff : staffs) {
                        if (staff.getId().equalsIgnoreCase(id)) {
                            System.out.println("ID đã tồn tại");
                            break;
                        } else {
                            dk = false;
                        }
                    }
                } while (dk);
            }
            System.out.println("Nhập tên: ");
            String name = sc.nextLine();
            System.out.println("Nhập tuổi: ");
            int age = sc.nextInt();
            System.out.println("Nhập hệ số lương: ");
            double heSoLuong = sc.nextDouble();
            sc.nextLine();
            String startDate;
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            // Khởi tạo đối tượng SimpleDateFormat  kiếm tra định dạng ngày tháng
            boolean validDate = true;
            do {
                System.out.println("Nhập ngày vào làm (dd/MM/yyyy): ");
                startDate = sc.nextLine();
                df.setLenient(false); // set false de kiem tra tinh hop le cua Date
                try {
                    df.parse(startDate); // chuyen startDate thanh kieu Date
                    validDate = false;
                }
                catch (ParseException e) { // bao loi neu startDate khong hop le
                    System.out.println("Bạn nhập sai ngày!");
                }
            } while(validDate);
            System.out.println("Bộ phận (1. IT, 2. Marketing, 3. HR): ");
            int chon1 = sc.nextInt();
            Department department = null;
            do {
                switch (chon1) {
                    case 1:
                        department = departments.get(0);
                        department.setNumberOfEmployee(department.getNumberOfEmployee() + 1);
                        break;
                    case 2:
                        department = departments.get(1);
                        department.setNumberOfEmployee(department.getNumberOfEmployee() + 1);
                        break;
                    case 3:
                        department = departments.get(2);
                        department.setNumberOfEmployee(department.getNumberOfEmployee() + 1);
                        break;
                    default:
                        System.out.println("Không có bộ phận bạn chọn.");
                        break;
                }
            } while (chon1 < 1 || chon1 > 3);
            System.out.println("Số ngày nghỉ: ");
            int numDayOff = sc.nextInt();
            System.out.println("Nhập chức danh (1. Business Leader 2. Project Leader  3.Technical Leader): ");
            int chon2 = sc.nextInt();
            String position = "";
            do {
                switch (chon2) {
                    case 1:
                        position = "Business Leader";
                        break;
                    case 2:
                        position = "Project Leader";
                        break;
                    case 3:
                        position = "Technical Leader";
                        break;
                    default:
                        System.out.println("Không có chức danh bạn chọn!");
                        break;
                }
            } while (chon2 < 1 || chon2 > 3);
            
            Staff manager = new Manager(id, name, age, heSoLuong, startDate, department, numDayOff, position);
            staffs.add(manager); // thêm đối tượng vào danh sách
        } else {
            System.out.println("Không có loại nhân viên này.");
        }
    }

    // 5 Tìm kiếm theo tên hoặc ID
    public void searchStaff(ArrayList<Staff> staffs, Scanner s) {

        System.out.print("Mời nhập ID hoặc tên nhân viên: ");
        String search = s.next();
        Staff staff = null;
        // Khởi tạo đối tượng staff = null
        for (Staff st : staffs) {
            //if (st.getId().equalsIgnoreCase(search) || st.getName().equalsIgnoreCase(search)) {
            if (st.getId().equalsIgnoreCase(search) || st.getName().contains(search)) {
                // kiểm tra id hoặc tên nhập vào có trùng với id và tên trong danh sách
                staff = st;
                break;
            }
        }
        if (staff != null) {
            System.out.println("Nhân viên có tên hoặc ID:");
            System.out.println("+------------------------------------------------------" +
                    "---------------------------------------+");
            System.out.format("|%5s |%15s |%5s |%12s |%12s |%10s | %20s |", "ID", "Name", "Age",
                    "Start Date", "Department", "Salary", "Position");
            System.out.println();
            System.out.println("+------------------------------------------------------" +
                    "---------------------------------------+");
            staff.displayInformation();
            // lấy ra đối tượng có id hoặc tên trùng với id hoặc tên trong danh sách
            // gọi phương thức displayInformation() để hiển thị ra màn hình
        } else {
            System.out.println("Không tìm thấy nhân viên có tên hoặc ID: " + search);
            // trả thông báo ne
        }
    }

    // 6 Hiển thị bảng lương của nhân viên toàn công ty
    public void showSalary(ArrayList<Staff> staffs) {

        if (staffs.isEmpty()) {
            // In thông báo nếu danh sách rỗng
            System.out.println("Danh sách rỗng!");
        } else {
            System.out.println("+------------------------------------------------------" +
                    "---------------------------------------+");
            System.out.format("|%5s |%15s |%5s |%12s |%12s |%10s | %20s |", "ID", "Name", "Age",
                    "Start Date", "Department", "Salary", "Position");
            System.out.println();
            System.out.println("+------------------------------------------------------" +
                    "---------------------------------------+");
            for (Staff st : staffs) {
                if (st instanceof Manager) {
                    ((Manager) st).displayInformation();
                } else if (st instanceof Employee) {
                    ((Employee) st).displayInformation();
                }
            }
        }
    }

    // 7 Hiển thị bảng lương của nhân viên theo thứ tự tăng dần
    public void salaryAscending(ArrayList<Staff> staffs) {
        if (staffs.isEmpty()) {
            // In thông báo nếu danh sách rỗng
            System.out.println("Danh sách rỗng!");
        } else {
            staffs.sort((a, b) -> (int) (a.calculateSalary() - b.calculateSalary()));
            // sắp xếp lương theo thứ tự tăng dần
            System.out.println("+------------------------------------------------------" +
                    "---------------------------------------+");
            System.out.format("|%5s |%15s |%5s |%12s |%12s |%10s | %20s |", "ID", "Name", "Age",
                    "Start Date", "Department", "Salary", "Position");
            System.out.println();
            System.out.println("+------------------------------------------------------" +
                    "---------------------------------------+");
            for (Staff st : staffs) {
                if (st instanceof Manager) {
                    ((Manager) st).displayInformation();
                } else if (st instanceof Employee) {
                    ((Employee) st).displayInformation();
                }
            }
        }
    }
}
