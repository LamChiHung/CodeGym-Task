import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Student student1 = new Student("Nam", 20, "HN");
//        Student student2 = new Student("Hung", 21, "HN");
//        Student student3 = new Student("Ha", 22, "HN");
//        Map <Integer, Student> hashMap = new HashMap <>();
//        hashMap.put(1, student1);
//        hashMap.put(2, student2);
//        hashMap.put(3, student3);
//        hashMap.put(3, student1);
//        for (Map.Entry <Integer, Student> student : hashMap.entrySet()) {
//            System.out.println(student.toString());
//        }
//        System.out.println("...........Set");
//        Set <Student> students = new HashSet <>();
//        students.add(student1);
//        students.add(student2);
//        students.add(student3);
//        students.add(student1);
//
//        for (Student student : students) {
//            System.out.println(student.toString());
//        }
        Student student = new Student("Kien", 30, "HT");
        Student student1 = new Student("Nam", 26, "HN");
        Student student2 = new Student("Anh", 38, "HT");
        Student student3 = new Student("Tung", 38, "HT");

        List <Student> lists = new ArrayList <>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        Collections.sort(lists);
        System.out.println(lists);

        AgeComparator ageComparator = new AgeComparator();
        lists.sort(ageComparator);
        System.out.println(lists);
    }
}