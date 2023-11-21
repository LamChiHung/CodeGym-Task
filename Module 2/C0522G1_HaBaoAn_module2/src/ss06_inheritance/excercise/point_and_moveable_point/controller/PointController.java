package ss06_inheritance.excercise.point_and_moveable_point.controller;

import ss06_inheritance.excercise.point_and_moveable_point.model.Point;

public class PointController {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);

        Point point1 = new Point(10, 7);
        System.out.println(point1);

    }
}
