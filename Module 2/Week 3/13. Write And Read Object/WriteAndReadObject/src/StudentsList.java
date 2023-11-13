import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class StudentsList implements Serializable {
    private ArrayList <Student> students = new ArrayList <>();

    public StudentsList() {

    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public void printStudenListToFile(File file) throws IOException {
        if (! file.exists()) {
            System.out.println(file.createNewFile());
        }
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Student student : students) {
                oos.writeObject(student);
            }
        }
    }

    public void readStudentListFromFile(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                Object o = ois.readObject();
                if (o == null) {
                    break;
                }
                System.out.println(o);
            }
        } catch (EOFException ignored) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
