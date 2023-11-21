package homework1.controller;

import homework1.service.IPersonService;
import homework1.service.IStudenService;
import homework1.service.impl.StudentService;

import java.io.IOException;
import java.util.Scanner;

public class StudentController {

    public static void menuStudent() throws IOException {
        Scanner scanner = new Scanner(System.in);
        IStudenService iStudenService = new StudentService();
        do {
            System.out.println("1. Thêm mới sinh viên\n" +
                    "2. Xóa sinh viên\n" +
                    "3. Hiển thị danh sách sinh viên\n" +
                    "4. Tìm kiếm sinh viên theo tên \n" +
                    "5. Tìm kiếm sinh viên theo Mã sinh viên \n" +
                    "6. Sắp xếp sinh viên theo tên \n" +
                    "7. Quay về Menu chính");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    iStudenService.add();
                    break;
                case 2:
                    iStudenService.remove();
                    break;
                case 3:
                    iStudenService.display();
                    break;
                case 4:iStudenService.searchPersonByName();
                    break;
                case 5:
                    iStudenService.searchPersonById();
                    break;
                case 6:
                    iStudenService.sortByName();
                    break;
                case 7:
                    return;
            }
        }while (true);
    }

}
