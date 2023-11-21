package ss07_abstract_class_amp_interface_edible.excercise.interface_colorable.controller;

import ss07_abstract_class_amp_interface_edible.excercise.resizeable.model.Shape;

public class ShapeTest {

    public static void main(String[] args) {
        Shape shape = new Shape() {
            @Override
            public double resize(double percent) {
                return 0;
            }
        };
        System.out.println(shape);

        shape = new Shape("red", false) {
            @Override
            public double resize(double percent) {
                return 0;
            }
        };
        System.out.println(shape);
    }
}
