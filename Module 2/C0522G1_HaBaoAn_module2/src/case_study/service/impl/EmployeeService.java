package case_study.service.impl;

import case_study.exception.AgeInvalidException;
import case_study.exception.DuplicateIDException;
import case_study.model.person.Employee;
import case_study.service.IEmployeeService;
import case_study.utils.ReadEmployeeUtils;
import case_study.utils.WriteEmployeeUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    public static Scanner scanner = new Scanner(System.in);
    public static final String PATH = "src/case_study/data/person_file/employee.csv";

    private String getLiteracy() {
        System.out.println("Hãy lựa chọn trình độ nhân viên \n" +
                "1. Trung cấp \n" +
                "2. Cao đẳng \n" +
                "3. Đại học \n" +
                "4. Sau Đại Học");
        do {
            try {
                int choose;
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        return "Trung cấp";
                    case 2:
                        return "Cao đẳng";
                    case 3:
                        return "Đại học";
                    case 4:
                        return "Sau Đại Học";
                }
            } catch (NumberFormatException | IllegalStateException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        } while (true);
    }

    private String getPosition() {
        System.out.println("Lựa chọn chức vụ nhân viên \n" +
                "1. Lễ Tân \n" +
                "2. Phục vụ \n" +
                "3. Chuyên viên \n" +
                "4. Giám sát \n" +
                "5. Quản lý \n" +
                "6. Giám đốc ");
        int choose1;
        do {
            try {
                choose1 = Integer.parseInt(scanner.nextLine());
                switch (choose1) {
                    case 1:
                        return " Lễ Tân";
                    case 2:
                        return "Phục vụ";
                    case 3:
                        return "Chuyên viên";
                    case 4:
                        return "Giám sát";
                    case 5:
                        return "Quản lý";
                    case 6:
                        return "Giám đốc";
                }
            } catch (NumberFormatException | IllegalStateException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (true);

    }

    private Employee infoEmployee() {
        List<Employee> list = ReadEmployeeUtils.readEmployeeList(PATH);
        List<Employee> employeeList = new ArrayList<>(list);


        String employeeCode;
        do {
            try {
                System.out.println("Nhập vào mã nhân viên");
                employeeCode = scanner.nextLine();
                if (employeeCode.matches("^(NV\\d{4})$")) {
                    for (Employee employee : list) {
                        if (employee.getEmployeeCode().equals(employeeCode)) {
                            throw new DuplicateIDException("Mã nhân viên đã có vui lòng nhập lại");
                        }
                    }
                    break;
                }

            } catch (DuplicateIDException e) {
                e.printStackTrace();
            }
        } while (true);

        System.out.println("Nhập vào tên nhân viên ");
        String name;
        do {
            try {
                name = scanner.nextLine();
                if (name.matches("[A-Z][^\\d]+[ ][A-Z][^\\d]+")) {
                    break;
                }
                throw new IOException("Bạn nhập sai định dạng tên, phải viết hoa chữ cái đầu");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (true);

        System.out.println("Nhập vào ngày sinh nhân viên");
        String dayOfBirth;
        do {
            try {
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat();
                double age;
                dayOfBirth = scanner.nextLine();
                if (dayOfBirth.matches("^(((0[1-9]|[12][0-9]|30)[-/](0[13-9]|1[012])|31[-/]" +
                        "(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-/]02)[-/][0-9]{4}|29[-/]02" +
                        "[-/]([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468]" +
                        "[048]|0[0-9]|1[0-6])00))$")) {
                    age = (date.getTime() -dateFormat.parse(dayOfBirth).getTime())/315576E5;
                    if (age<18|age>100 ){
                        throw new AgeInvalidException("Nhân viên phải trên 18 tuổi và không quá 100 tuổi");
                    }
                    System.out.println("Ngày sinh " +dayOfBirth);
                    break;
                }
            }
            catch (ParseException | AgeInvalidException e) {
                e.printStackTrace();
            }
        }while (true);

        String gender = getGender();

        System.out.println("Nhập vào số CMND/Căn cước của nhân viên");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                System.out.println("ID : " + id);
                for (Employee employee : employeeList) {
                    if (employee.getId() == id) {
                        throw new DuplicateIDException("Số CMND/Căn cước của nhân viên đã có vui lòng nhập lại");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập sai định dạng,vui lòng nhập lại");
            } catch (DuplicateIDException e) {
                System.out.println(e.getMessage());
            }
        }


        System.out.println("Nhập vào số điện thoại của nhân viên");
        int phoneNumber;
        while (true) {
            try {
                phoneNumber = Integer.parseInt(scanner.nextLine());
                System.out.println("Số điện thoại" + phoneNumber);
                for (Employee employee : employeeList) {
                    if (employee.getPhoneNumber() == id) {
                        throw new DuplicateIDException("Số điện thoại bị trùng vui lòng nhập lại");
                    }

                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập sai định dạng,vui lòng nhập lại");
            } catch (DuplicateIDException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Nhập vào email của nhân viên");
        String email = scanner.nextLine();

        String literacy = getLiteracy();

        String position = getPosition();

        System.out.println("Nhập vào lương nhân viên");
        long salary;
        while (true) {
            try {
                salary = Integer.parseInt(scanner.nextLine());
                System.out.println("Lương" + salary);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập sai định dạng,vui lòng nhập lại");
            }
        }

        return new Employee(employeeCode,
                name,
                dayOfBirth,
                gender,
                id,
                phoneNumber,
                email,
                literacy,
                position,
                salary);

    }

    private String getGender() {
        System.out.println("Nhập vào lựa chọn giới tính của bạn\n" +
                "1. Nam \n" +
                "2. Nữ \n" +
                "3. LGBT");
        do {
            try {
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        return "Nam";
                    case 2:
                        return "Nữ";
                    case 3:
                        return "LGBT";
                }
            } catch (NumberFormatException | IllegalStateException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        } while (true);

    }

    @Override
    public void add() {
        List<Employee> list = ReadEmployeeUtils.readEmployeeList(PATH);
        List<Employee> employeeList = new ArrayList<>(list);

        Employee employee = infoEmployee();
        employeeList.add(employee);

        WriteEmployeeUtils.writeEmployeeFile(PATH, employeeList);

        System.out.println("Thêm mới thành công");
    }

    @Override
    public void display() {
        List<Employee> list = ReadEmployeeUtils.readEmployeeList(PATH);
        List<Employee> employeeList = new ArrayList<>(list);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

    }

    @Override
    public void edit() {
        System.out.println("Nhập vào mã nhân viên bạn cần thay đổi");
        String employeeIDSearch = scanner.nextLine();

        List<Employee> list = ReadEmployeeUtils.readEmployeeList(PATH);
        List<Employee> employeeLists = new ArrayList<>(list);

        for (Employee employee : employeeLists) {
            if (employeeIDSearch.equals(employee.getEmployeeCode())) {
                do {

                    System.out.println("Nhập vào sô của lựa chọn bạn muốn thay đổi \n" +
                            "1. Đổi tên \n" +
                            "2. Đổi ngày sinh \n" +
                            "3. Đổi lại chức vụ nhân viên \n" +
                            "4. Đổi lại lương nhân viên \n" +
                            "5. Đổi lại trình độ của nhân viên \n" +
                            "6. Đổi lại số điện thoại \n" +
                            "7. Đổi lại email \n" +
                            "8. Đổi lại giới tính \n" +
                            "9. Đổi lại số CMND/Căn cước " +
                            "10. Trở lại Menu trước\n"
                    );
                    int choose = Integer.parseInt(scanner.nextLine());
                    switch (choose) {
                        case 1:
                            System.out.println("Nhập vào tên mới của nhân viên");
                            String newName = scanner.nextLine();
                            employee.setName(newName);
                            WriteEmployeeUtils.writeEmployeeFile(PATH, employeeLists);
                            return;
                        case 2:
                            System.out.println("Nhập vào ngày sinh của nhân viên");
                            String newDateOfBirth = scanner.nextLine();
                            employee.setDateOfBirth(newDateOfBirth);
                            WriteEmployeeUtils.writeEmployeeFile(PATH, employeeLists);
                            return;
                        case 3:
                            System.out.println("Nhập vào chức vụ của nhân viên");
                            String newPosition = getPosition();
                            employee.setPosition(newPosition);
                            WriteEmployeeUtils.writeEmployeeFile(PATH, employeeLists);
                            return;
                        case 4:
                            System.out.println("Nhập vào lương của nhân viên");
                            int newSalary = Integer.parseInt(scanner.nextLine());
                            employee.setSalary(newSalary);
                            WriteEmployeeUtils.writeEmployeeFile(PATH, employeeLists);
                            return;
                        case 5:
                            String newLiteracy = getLiteracy();
                            employee.setLiteracy(newLiteracy);
                            WriteEmployeeUtils.writeEmployeeFile(PATH, employeeLists);
                            return;
                        case 6:
                            do {
                                try {
                                    System.out.println("Nhập vào số điện thoại của nhân viên");
                                    long newPhoneNumber = Long.parseLong(scanner.nextLine());
                                    employee.setPhoneNumber((int) newPhoneNumber);
                                    WriteEmployeeUtils.writeEmployeeFile(PATH, employeeLists);
                                    return;
                                } catch (NumberFormatException e) {
                                    e.printStackTrace();
                                    System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại kiểu sổ");
                                }
                            } while (true);


                        case 7:
                            System.out.println("Nhập vào email");
                            String newEmail = scanner.nextLine();
                            employee.setEmail(newEmail);
                            WriteEmployeeUtils.writeEmployeeFile(PATH, employeeLists);
                            return;
                        case 8:
                            employee.setGender(getGender());
                            WriteEmployeeUtils.writeEmployeeFile(PATH, employeeLists);
                            return;
                        case 9:
                            System.out.println("Nhập vào số CMND/Căn cước");
                            long newID = Long.parseLong(scanner.nextLine());
                            employee.setId(newID);
                            WriteEmployeeUtils.writeEmployeeFile(PATH, employeeLists);
                            return;
                        case 10:
                            return;
                        default:
                            break;
                    }

                } while (true);

            }
        }

    }

}
