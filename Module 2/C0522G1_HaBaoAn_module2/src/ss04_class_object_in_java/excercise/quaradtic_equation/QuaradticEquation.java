package ss04_class_object_in_java.excercise.quaradtic_equation;

import java.util.Scanner;

public class QuaradticEquation {
    double a, b, c;

    private QuaradticEquation() {
    }

    QuaradticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private double getA() {
        return this.a;
    }

    private double getB() {
        return this.b;
    }

    private double getC() {
        return this.c;
    }

    double getDiscriminant() {
        return getB() * getB() - 4 * getA() * getC();
    }

    double getRoot1() {
        return (-getB() + Math.sqrt(getB() * getB() - 4 * getA() * getC())) / (2 * getA());
    }

    double getRoot2() {
        return (-getB() - Math.sqrt(getB() * getB() - 4 * getA() * getC())) /( 2 * getA());
    }


}
