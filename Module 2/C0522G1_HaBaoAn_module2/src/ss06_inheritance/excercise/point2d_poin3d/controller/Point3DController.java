package ss06_inheritance.excercise.point2d_poin3d.controller;

import ss06_inheritance.excercise.point2d_poin3d.model.Point3D;

import java.util.Arrays;

public class Point3DController {
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println(point3D);

        Point3D point3D1 = new Point3D(5, 7, 9);
        System.out.println(point3D1);

        float[] array = point3D1.getXYZ();
        System.out.println(Arrays.toString(array));

    }
}
