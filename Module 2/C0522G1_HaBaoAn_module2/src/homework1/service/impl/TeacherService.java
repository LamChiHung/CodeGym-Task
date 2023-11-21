package homework1.service.impl;

import homework1.model.Teacher;
import homework1.service.IPersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements IPersonService {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();

    public static Teacher infoOfTeacher() {
        System.out.print("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập name: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh: ");
        String dayOfBirth = scanner.nextLine();
        System.out.println("Nhập vào giới tính");
        String gender = scanner.nextLine();
        System.out.println("Nhập vào chuyên môn");
        String specialize = scanner.nextLine();
        Teacher teacher = new Teacher();
        return teacher;
    }



    @Override
    public void add() {
        Teacher teacher = infoOfTeacher();
        teacherList.add(teacher);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void remove() {
        System.out.println("Mời bạn nhập ID cần xóa");
        int idRemove = Integer.parseInt(scanner.nextLine());
        boolean isFlag = false;
        for (Teacher teacher : teacherList) {
            if (teacher.getId() == idRemove) {
                System.out.println(" Bạn có chắc muốn xóa hay không? \n" +
                        "1. Có \n" +
                        "2. Không");
                int chooseYesNo = Integer.parseInt(scanner.nextLine());
                if (chooseYesNo == 1) {
                    teacherList.remove(teacher);
                    System.out.println("Xóa thành công!.");
                }
                isFlag = true;
                break;
            }
        }
        if (!isFlag) {
            System.out.println("Không tìm thấy");
        }
    }


    @Override
    public void display() {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void sortByName() {

    }
}

