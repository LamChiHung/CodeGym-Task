package ss07_abstract_class_amp_interface_edible.excercise.interface_colorable.controller;


import ss07_abstract_class_amp_interface_edible.excercise.interface_colorable.model.Circle;
import ss07_abstract_class_amp_interface_edible.excercise.interface_colorable.model.Rectangle;
import ss07_abstract_class_amp_interface_edible.excercise.interface_colorable.model.Shape;
import ss07_abstract_class_amp_interface_edible.excercise.interface_colorable.model.Square;

import java.util.Scanner;

public class ColorableController {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(5, 10);
        shapes[1] = new Square(10);
        shapes[2] = new Circle(6);
        for (Shape shape : shapes) {
            System.out.println(shape);
            if (shape instanceof Square) {
                Shape shape1 = (Square) shape;
                System.out.println(shape1.howToColor());
            }


        }
    }
}
