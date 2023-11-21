package ss07_abstract_class_amp_interface_edible.excercise.resizeable.controller;

import ss07_abstract_class_amp_interface_edible.excercise.resizeable.model.Rectangle;

public class RectangleTest {
    public static void main(String[] args) {
     Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangle);
    }
}
