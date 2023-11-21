package ss06_inheritance.excercise.point2d_poin3d.controller;

import ss06_inheritance.excercise.point2d_poin3d.model.Poin2D;

import java.util.Arrays;

public class Point2DController {
    public static void main(String[] args) {
        Poin2D poin2D = new Poin2D();
        System.out.println(poin2D);

        Poin2D poin2D1 = new Poin2D(5, 6);
        System.out.println(poin2D1);

        float[] array = poin2D1.getXY();
        System.out.println(Arrays.toString(array));
    }
}
