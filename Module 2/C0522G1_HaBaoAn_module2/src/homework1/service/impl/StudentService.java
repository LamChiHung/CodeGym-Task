package homework1.service.impl;

import homework1.exception.DateFormatException;
import homework1.exception.DuplicateIDException;
import homework1.model.Student;

import homework1.service.IStudenService;
import homework1.utils.ReadFileUtils;
import homework1.utils.WriteFileUtils;

import java.util.*;

public class StudentService implements IStudenService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PATH = "src/homework1/list_file/person.csv";
    private static List<Student> studentList = new ArrayList<>();


    private static void readFile() {
        List<Student> list = ReadFileUtils.readStudenList(PATH);
        studentList.clear();
        studentList.addAll(list);
    }

    private static void writeFile() {
        WriteFileUtils.writeStudentFile(PATH, studentList);
    }


    private static Student infoStudent() {
        System.out.print("Nhập id: ");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(SCANNER.nextLine());
                System.out.println("ID : " + id);
                for (Student student : studentList) {
                    if (student.getId() == id) {
                        throw new DuplicateIDException("ID đã có,vui lòng nhập lại");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn có chắc mình nhập đúng,hãy nhập lại");
            } catch (DuplicateIDException e) {
                System.out.println(e.getMessage());
            }
        }
        String name = AnyMethod.getName(SCANNER.nextLine());

        String dayOfBirth = SCANNER.nextLine();
        AnyMethod.getDayOfBirth(dayOfBirth);

        String gender = AnyMethod.getGender().trim();
        System.out.println("Giới tính : " + gender);

        System.out.print("Nhập điểm: ");
        double score;
        while (true) {
            try {
                score = Double.parseDouble(SCANNER.nextLine());
                System.out.println("Điểm: " + score);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn có chắc mình nhập đúng,hãy nhập lại");
            }
        }
        System.out.print("Nhập tên Lớp: ");
        String className = SCANNER.nextLine();
        System.out.println("Lớp: " + className.trim());

        return new Student(id, name, dayOfBirth, gender, className, score);
    }

    @Override
    public void add() {
        readFile();
        Student student = infoStudent();
        studentList.add(student);
        writeFile();
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void remove() {
        readFile();
        System.out.println("Mời bạn nhập ID cần xóa");
        int idRemove;
        while (true) {
            try {
                idRemove = Integer.parseInt(SCANNER.nextLine());
                boolean isFlag = false;
                for (Student student : studentList) {
                    if (student.getId() == idRemove) {
                        System.out.println(" Bạn có chắc muốn xóa hay không? \n" +
                                "1. Có \n" +
                                "2. Không");
                        int chooseYesNo = Integer.parseInt(SCANNER.nextLine());
                        if (chooseYesNo == 1) {
                            studentList.remove(student);
                            writeFile();
                            System.out.println("Xóa thành công!.");
                        }
                        isFlag = true;
                        break;

                    }
                }
                if (!isFlag) {
                    System.out.println("Không tìm thấy");
                }
                return;
            } catch (NumberFormatException e) {
                System.out.println("Bạn có chắc mình nhập đúng ID");
            }
        }
    }


    @Override
    public void display() {
        readFile();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void sortByName() {
        readFile();
        boolean isSwap = true;
        for (int i = 0; i < studentList.size() && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < studentList.size() - 1 - i; j++) {
                if (studentList.get(j).getName().compareTo(studentList.get(j + 1).getName()) > 0) {
                    Collections.swap(studentList, j, j + 1);
                    isSwap = true;
                }
                if (studentList.get(j).getName().compareTo(studentList.get(j + 1).getName()) == 0) {
                    if (studentList.get(j).getId() > studentList.get(j + 1).getId()) {
                        Collections.swap(studentList, j, j + 1);
                        isSwap = true;
                    }
                }
            }
        }
        writeFile();
    }

    @Override
    public void searchPersonById() {
        readFile();
        System.out.println("Nhập vào mã sinh viên cần tìm");
        int idSearch;
        while (true) {
            try {
                idSearch = Integer.parseInt(SCANNER.nextLine());
                for (Student str : studentList) {
                    if (idSearch == str.getId()) {
                        System.out.println(str);
                    }
                }
                return;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập sai rồi, xin nhập lại");
            }
        }
    }

    @Override
    public void searchPersonByName() {
        readFile();
        System.out.println("Nhập vào tên sinh viên cần tìm");
        String nameSearch = SCANNER.nextLine();
        boolean flag = false;
        for (Student str : studentList) {
            if (str.getName().toLowerCase().contains(nameSearch.toLowerCase())) {
                System.out.println(str);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy");
        }
    }
}


