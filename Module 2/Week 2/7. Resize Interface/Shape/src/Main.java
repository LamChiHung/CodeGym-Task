public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Triangle();
        shapes[1] = new Rectangle();
        shapes[2] = new Circle();

        for (Shape shape : shapes) {
            if (shape instanceof Colorable) {
                System.out.println(shape);
                ((Colorable) shape).howToColor();
            }
        }

    }
}