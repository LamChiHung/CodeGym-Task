public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation() {

    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return (Math.pow(this.b, 2) - 4 * a * c);
    }

    public double getRoot1() {
        return (- b + Math.pow(this.getDiscriminant(), 0.5)) / 2;
    }

    public double getRoot2() {
        return (- b - Math.pow(this.getDiscriminant(), 0.5)) / 2;
    }

    public void result() {
        if (this.getDiscriminant() > 0) {
            System.out.printf("result 1: %.2f, result 2: %.2f", this.getRoot1(), this.getRoot2());
        } else if (this.getDiscriminant() == 0) {
            System.out.printf("result 1 and 2: %.2f", this.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}
