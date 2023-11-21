package ss10_dsa_list.excercise.method_arraylist.model;

public class Student extends Person implements Comparable<Student>{
    private double score;

    public Student(double score) {
        this.score = score;
    }

    public Student(int id, String name, double score) {
        super(id, name);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" +
                "score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (this.score > o.score) {
            return 1;// số nguyên dương => sắp xếp
        } else if (this.score == o.score) {
            return 0;// Không sắp xếp
        } else {
            return -1;// Không sắp xếp
        }
    }
}
