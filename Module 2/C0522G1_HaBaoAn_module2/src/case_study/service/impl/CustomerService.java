package case_study.service.impl;

import case_study.exception.AgeInvalidException;
import case_study.exception.DuplicateIDException;
import case_study.model.person.Customer;
import case_study.service.ICustomerService;
import case_study.utils.ReadCustomerUtils;
import case_study.utils.WriteCustomerUtils;

import java.text.*;
import java.util.*;
import java.util.regex.PatternSyntaxException;

public class CustomerService implements ICustomerService {
    public static Scanner scanner = new Scanner(System.in);
    public static final String PATH = "src/case_study/data/person_file/customer.csv";

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

    private Customer infoCustomer() {
        List<Customer> list = ReadCustomerUtils.readCustomerList(PATH);
        List<Customer> customerList = new LinkedList<>(list);

        System.out.println("Nhập vào mã khách hàng");
        String customerCode = scanner.nextLine();
        System.out.println("Mã khách hàng: " + customerCode);

        System.out.println("Nhập vào tên khách hàng ");
        String name = scanner.nextLine();
        System.out.println("Tên khách hàng: " + name);

        System.out.println("Nhập vào ngày sinh khách hàng");
        String dayOfBirth;
        do {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            double age;
            try {
                dayOfBirth = scanner.nextLine();
                if (dayOfBirth.matches("^(((0[1-9]|[12][0-9]|30)[-/](0[13-9]|1[012])|31[-/]" +
                        "(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-/]02)[-/][0-9]{4}|29[-/]02" +
                        "[-/]([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468]" +
                        "[048]|0[0-9]|1[0-6])00))$")) {
                    age = (date.getTime() - dateFormat.parse(dayOfBirth).getTime()) / 315576E5;
                    if (age < 18 | age > 100) {
                        throw new AgeInvalidException("Khách hàng phải trên 18 tuổi và không quá 100 tuổi");
                    }
                    System.out.println("Ngày sinh " + dayOfBirth);
                    break;
                }
                System.out.println("Vui lòng nhập đúng định dạng dd/mm/yyyy");
            } catch (PatternSyntaxException | ParseException | AgeInvalidException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (true);

        String gender = getGender();

        System.out.println("Nhập vào số CMND/Căn cước của khách hàng");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                System.out.println("ID : " + id);
                for (Customer customer : customerList) {
                    if (customer.getId() == id) {
                        throw new DuplicateIDException("Số CMND/Căn cước của khách hàng đã có vui lòng nhập lại");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập sai định dạng,vui lòng nhập lại");
            } catch (DuplicateIDException e) {
                System.out.println(e.getMessage());
            }
        }


        System.out.println("Nhập vào số điện thoại của khách hàng");
        int phoneNumber;
        while (true) {
            try {
                phoneNumber = Integer.parseInt(scanner.nextLine());
                System.out.println("Số điện thoại" + phoneNumber);
                for (Customer customer : customerList) {
                    if (customer.getPhoneNumber() == id) {
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

        System.out.println("Nhập vào email của khách hàng");
        String email = scanner.nextLine();


        System.out.println("Nhập vào xếp hạng khách hàng");
        String customerType = getCustomerType();

        System.out.println("Nhập vào địa chỉ khách hàng");
        String customerAddress = scanner.nextLine();

        return new Customer(customerCode, name, dayOfBirth, gender, id, phoneNumber, email, customerType, customerAddress);
    }

    private String getCustomerType() {
        System.out.println("Vui lòng lựa chọn hạng thành viên của khách hàng\n" +
                "1. Thành viên \n" +
                "2. Bạc \n" +
                "3. Vàng \n" +
                "4. Bạch kim \n" +
                "5. Kim cương");

        do {
            try {
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        return "Thành viên";
                    case 2:
                        return "Bạc";
                    case 3:
                        return "Vàng";
                    case 4:
                        return "Bạch kim";
                    case 5:
                        return "Kim cương";
                }
            } catch (NumberFormatException | IllegalStateException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        } while (true);
    }


    @Override
    public void add() {
        List<Customer> list = ReadCustomerUtils.readCustomerList(PATH);
        List<Customer> customerList = new LinkedList<>(list);

        Customer customer = infoCustomer();
        customerList.add(customer);

        WriteCustomerUtils.writeCustomerFile(PATH, customerList);
    }

    @Override
    public void display() {
        List<Customer> list = ReadCustomerUtils.readCustomerList(PATH);
        List<Customer> customerList = new LinkedList<>(list);
        for (Customer customer : customerList) {
            System.out.println(customer);
        }

    }

    @Override
    public void edit() {
        System.out.println("Nhập vào mã khách hàng bạn cần thay đổi thông tin");
        String customerIDSearch = scanner.nextLine();

        List<Customer> list = ReadCustomerUtils.readCustomerList(PATH);
        List<Customer> customerList = new LinkedList<>(list);

        for (Customer customer : customerList) {
            if (customerIDSearch.equals(customer.getCustomerCode())) {
                do {

                    System.out.println("Nhập vào sô của lựa chọn bạn muốn thay đổi \n" +
                            "1. Đổi tên \n" +
                            "2. Đổi ngày sinh \n" +
                            "3. Đổi lại xếp hạng khách hàng \n" +
                            "4. Đổi lại địa chỉ khách hàng \n" +
                            "5. Đổi lại số điện thoại \n" +
                            "6. Đổi lại email \n" +
                            "7. Đổi lại giới tính \n" +
                            "8. Đổi lại số CMND/Căn cước " +
                            "9. Trở lại Menu trước\n"
                    );
                    int choose = Integer.parseInt(scanner.nextLine());
                    switch (choose) {
                        case 1:
                            System.out.println("Nhập vào tên mới của nhân viên");
                            String newName = scanner.nextLine();
                            customer.setName(newName);
                            WriteCustomerUtils.writeCustomerFile(PATH, customerList);
                            return;
                        case 2:
                            System.out.println("Nhập vào ngày sinh của nhân viên");
                            String newDateOfBirth = scanner.nextLine();
                            customer.setDateOfBirth(newDateOfBirth);
                            WriteCustomerUtils.writeCustomerFile(PATH, customerList);
                            return;
                        case 3:
                            customer.setCustomerType(getCustomerType());
                            WriteCustomerUtils.writeCustomerFile(PATH, customerList);
                            return;
                        case 4:
                            System.out.println("Nhập vào địa chỉ khách hàng");
                            String newAddress = scanner.nextLine();
                            customer.setCustomerAddress(newAddress);
                            return;
                        case 5:
                            do {
                                try {
                                    System.out.println("Nhập vào số điện thoại của khách hàng");
                                    long newPhoneNumber = Long.parseLong(scanner.nextLine());
                                    customer.setPhoneNumber((int) newPhoneNumber);
                                    WriteCustomerUtils.writeCustomerFile(PATH, customerList);
                                    return;
                                } catch (NumberFormatException e) {
                                    e.printStackTrace();
                                    System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại kiểu sổ");
                                }
                            } while (true);


                        case 6:
                            System.out.println("Nhập vào email");
                            String newEmail = scanner.nextLine();
                            customer.setEmail(newEmail);
                            WriteCustomerUtils.writeCustomerFile(PATH, customerList);
                            return;
                        case 7:
                            customer.setGender(getGender());
                            WriteCustomerUtils.writeCustomerFile(PATH, customerList);
                            return;
                        case 8:
                            System.out.println("Nhập vào số CMND/Căn cước");
                            long newID = Long.parseLong(scanner.nextLine());
                            customer.setId(newID);
                            WriteCustomerUtils.writeCustomerFile(PATH, customerList);
                            return;
                        case 9:
                            return;
                        default:
                            break;
                    }

                } while (true);

            }
        }

    }
}

