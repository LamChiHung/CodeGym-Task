package ss05_access_modifier.excercise.student;

public class Student {
   private String name = "John";
   private String classe = "C02";

    protected Student(){
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classe='" + classe + '\'' +
                '}';
    }
}
