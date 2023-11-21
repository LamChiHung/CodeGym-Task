package ss05_access_modifier.practice.static_method;

import ss05_access_modifier.practice.static_method.Student;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();

        Student s1 = new Student(111,"Hoàng");
        Student s2 = new Student(222,"Khánh");
        Student s3 = new Student(333, "Nam");

        s1.display();
        s2.display();
        s3.display();
    }
}
