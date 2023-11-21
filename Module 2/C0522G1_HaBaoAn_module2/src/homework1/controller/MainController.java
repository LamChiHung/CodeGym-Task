package homework1.controller;

import java.io.IOException;
import java.util.Scanner;

public class MainController {
    public static void mainController() throws IOException {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Chào mừng bạn đến với Hệ thống quản lý \n"+
                    "Chọn chức năng theo số \n"+
                    "1.Quản lý sinh viên\n" +
                    "2. Quản lý Giảng viên\n" +
                    "3.Thoát chương trình");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    StudentController studentController = new StudentController();
                    studentController.menuStudent();
                    break;
                case 2:
                    TeacherController teacherController = new TeacherController();
                    teacherController.menuTeacher();
                    break;
                case 3:
                    System.exit(0);
            }
        }while (true);
    }
}
