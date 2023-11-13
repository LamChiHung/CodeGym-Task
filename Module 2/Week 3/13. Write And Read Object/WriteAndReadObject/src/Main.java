import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Student student1 = new Student(1, "A", "A");
        Student student2 = new Student(2, "B", "B");
        Student student3 = new Student(3, "C", "C");
        StudentsList studentsList = new StudentsList();
        studentsList.addStudent(student1);
        studentsList.addStudent(student2);
        studentsList.addStudent(student3);
        File file = new File(".\\Students");
        studentsList.printStudenListToFile(file);
        studentsList.readStudentListFromFile(file);
    }
}