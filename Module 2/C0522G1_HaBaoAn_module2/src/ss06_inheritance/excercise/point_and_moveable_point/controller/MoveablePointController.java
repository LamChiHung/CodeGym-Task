package ss06_inheritance.excercise.point_and_moveable_point.controller;

import ss06_inheritance.excercise.point_and_moveable_point.model.MoveablePoint;

public class MoveablePointController {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);

        MoveablePoint moveablePoint1 = new MoveablePoint(10, 5, 20, 5);
        System.out.println(moveablePoint1);
        System.out.println(moveablePoint1.move());
    }
}
