import java.util.Scanner;

public class FindInArray {
    public static void main(String[] args) {
        String[] students = {"A", "B", "C", "D", "E", "F"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the student name: ");
        String name = sc.nextLine();
        int i = 0;
        boolean exist = false;
        for (String student : students) {
            if (student.equals(name)) {
                System.out.println("Position of student in the list is: " + i);
                exist = true;
            }
            i++;
        }
        if (! exist) {
            System.out.println("The student is not exist");
        }
    }
}
