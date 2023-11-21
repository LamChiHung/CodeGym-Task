package homework1.service.impl;

import homework1.exception.DateFormatException;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class AnyMethod {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getName(String str) {
        do {
            try {
                str = str.toLowerCase().trim();
                str = str.replaceAll("[ ]+", "[ ]{1}");
                String[] arrStr = str.split(" ");
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : arrStr) {
                    stringBuilder.append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).append(" ");
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                return stringBuilder.toString();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (true);

    }

    public static String getDayOfBirth(String dayOfBirth) {
        do {
            try {
                System.out.print("Nhập ngày sinh: ");
                if (dayOfBirth.matches("^(((0[1-9]|[12][0-9]|30)[-/](0[13-9]|1[012])|31[-/](0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-/]02)[-/][0-9]{4}|29[-/]02[-/]([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$"))
                {
                    System.out.println("Ngày sinh: " + dayOfBirth.trim());
                    return dayOfBirth;
                }else{
                    throw new DateFormatException("Bạn nhập sai định dạng\n" +
                            "Định dạng đúng là dd/MM/YYYY");
                }

            } catch (DateFormatException |
                    PatternSyntaxException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        } while (true);
    }

    public static String getGender() {
        do {
            try {
                System.out.println("Vui lòng lựa chọn giới tính \n" +
                        "1. Nam \n" +
                        "2. Nữ \n" +
                        "3. LGBT");
                int choose = Integer.parseInt(SCANNER.nextLine());
                switch (choose) {
                    case 1:
                        return "Nam";
                    case 2:
                        return "Nữ";
                    case 3:
                        return "LGBT";
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (true);
    }

}

