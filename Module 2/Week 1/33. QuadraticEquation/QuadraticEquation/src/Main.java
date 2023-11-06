public class Main {
    public static void main(String[] args) {
        QuadraticEquation equation = new QuadraticEquation(1, 2, 1);
        System.out.println(equation.getDiscriminant());
        equation.result();
    }
}