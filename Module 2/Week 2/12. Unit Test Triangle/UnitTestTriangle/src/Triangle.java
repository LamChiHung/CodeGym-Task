import java.util.Arrays;

public class Triangle {
    public static String classifyTriangle(double side1, double side2, double side3) {
        double[] sides = new double[3];
        sides[0] = side1;
        sides[1] = side2;
        sides[2] = side3;
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            return "Khong phai tam giac";
        }
        if (side1 == side2 && side1 == side3) {
            return "Tam giac deu";
        }
        if (side1 == side2 || side1 == side3 || side2 == side3) {
            return "Tam giac can";
        }
        Arrays.sort(sides);
        if (sides[0] + sides[1] > sides[2]) {
            return "Tam giac thuong";
        } else {
            return "Khong phai tam giac";
        }
    }
}
