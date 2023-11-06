import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point2D p2d = new Point2D(1, 2);
        for (int i = 0; i < p2d.getXY().length; i++) {
            System.out.println(p2d.getXY()[i]);
        }
        System.out.println(p2d.toString());

        Point3D p3d = new Point3D(1, 2, 3);
        for (float element : p3d.getXYZ()) {
            System.out.println(element);
        }
        System.out.println(p3d.toString());

        MoveablePoint mp = new MoveablePoint(0, 0, 1, 1);
        System.out.println(mp);
        System.out.println(Arrays.toString(mp.getSpeed()));
        System.out.println(mp.move());
        System.out.println(mp.move());
    }
}