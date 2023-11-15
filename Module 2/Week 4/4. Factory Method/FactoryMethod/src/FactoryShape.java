public class FactoryShape {

    public FactoryShape() {
    }

    public Shape creatShape(String shape) {
        if (shape.equals("circle")) {
            return new Circle();
        } else if (shape.equals("rectangle")) {
            return new Rectangle();
        } else if (shape.equals("square")) {
            return new Square();
        }
        return null;
    }
}
