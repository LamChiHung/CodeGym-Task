package ss10_dsa_list.excercise.method_arraylist.view;


import ss10_dsa_list.excercise.method_arraylist.service.impl.MyListService;

public class View {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student a = new Student(1, "Huy");
        Student b = new Student(2, "Cường");
        Student c = new Student(3, "Hải");
        Student d = new Student(4, "Hoàng");
        Student e = new Student(5, "Hoa");


        MyListService<Student> studentMyListService = new MyListService<>();
        studentMyListService.add(a);
        studentMyListService.add(b);
        studentMyListService.add(c);
        studentMyListService.add(d);
        studentMyListService.add(e);


        for (int i = 0;i<studentMyListService.size();i++){
            Student student = (Student) studentMyListService.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());

        }
    }
}

