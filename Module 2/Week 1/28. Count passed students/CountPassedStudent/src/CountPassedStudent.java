import java.util.Scanner;

public class CountPassedStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        int count = 0;
        do {
            System.out.println("Input numbers of student");
            number = sc.nextInt();
            if (number > 30) {
                System.out.println("Input number < 30");
            }
        } while (number > 30);
        int[] gradeList = new int[number];
        int index = 1;
        for (int grade : gradeList) {
            System.out.printf("Input grade of student[%d]", index);
            grade = sc.nextInt();
            if (grade >= 5) {
                count++;
            }
            index++;
        }
        System.out.println("Numbers of passed student: " + count);
    }
}
