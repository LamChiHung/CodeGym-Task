public class Main {
    public static void main(String[] args) {
        FactoryShape factoryShape = new FactoryShape();
        Shape shape1 = factoryShape.creatShape("circle");
        Shape shape2 = factoryShape.creatShape("rectangle");
        Shape shape3 = factoryShape.creatShape("square");
        shape1.draw();
        shape2.draw();
        shape3.draw();

    }
}