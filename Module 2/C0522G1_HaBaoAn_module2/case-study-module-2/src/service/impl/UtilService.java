package service.impl;

import exception.AgeInvalidException;
import exception.DuplicateIDException;
import model.person.Customer;
import model.person.Person;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class UtilService {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getGender() {
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

    public static String getDateOfBirth() {
        String dayOfBirth;
        do {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
            double age;
            try {
                dayOfBirth = scanner.nextLine();
                if (dayOfBirth.matches("\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}")) {
                    age = (date.getTime() - dateFormat.parse(dayOfBirth).getTime()) / 315576E5;
                    if (age < 18 | age > 100) {
                        throw new AgeInvalidException("Khách hàng phải trên 18 tuổi và không quá 100 tuổi");
                    }
                    System.out.println("Ngày sinh " + dayOfBirth);
                    return dayOfBirth;
                }
                System.out.println("Vui lòng nhập đúng định dạng dd/mm/yyyy");
            } catch (PatternSyntaxException | ParseException | AgeInvalidException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static String getIdCard(List<Person> customerList) {
        String id;
        do {
            try {
                id = scanner.nextLine();
                System.out.println("ID : " + id);
                for (Person person : customerList) {
                    if (person.getIdCard().equals(id)) {
                        throw new DuplicateIDException("Số CMND/Căn cước của khách hàng đã có vui lòng nhập lại");
                    }
                }
                return id;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập sai định dạng,vui lòng nhập lại");
            } catch (DuplicateIDException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

}
