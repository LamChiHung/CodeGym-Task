package ss05_access_modifier.excercise.student;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student);

        student.setClasse("C0522G1");
        student.setName("Hà Bảo Ân");
        System.out.println(student);
    }
}
