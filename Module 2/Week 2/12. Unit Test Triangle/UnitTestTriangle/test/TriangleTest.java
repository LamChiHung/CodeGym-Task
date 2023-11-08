import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TriangleTest {

    @Test
    void testClassifyTriangle_2_2_2() {
        double side1 = 2;
        double side2 = 2;
        double side3 = 2;
        String expected = "Tam giac deu";
        String result = Triangle.classifyTriangle(side1, side2, side3);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testClassifyTriangle_2_2_3() {
        double side1 = 2;
        double side2 = 2;
        double side3 = 3;
        String expected = "Tam giac can";
        String result = Triangle.classifyTriangle(side1, side2, side3);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testClassifyTriangle_3_4_5() {
        double side1 = 3;
        double side2 = 4;
        double side3 = 5;
        String expected = "Tam giac thuong";
        String result = Triangle.classifyTriangle(side1, side2, side3);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testClassifyTriangle_8_2_3() {
        double side1 = 8;
        double side2 = 2;
        double side3 = 3;
        String expected = "Khong phai tam giac";
        String result = Triangle.classifyTriangle(side1, side2, side3);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testClassifyTriangle_negative1_2_1() {
        double side1 = - 1;
        double side2 = 2;
        double side3 = 1;
        String expected = "Khong phai tam giac";
        String result = Triangle.classifyTriangle(side1, side2, side3);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testClassifyTriangle_0_1_1() {
        double side1 = 0;
        double side2 = 1;
        double side3 = 1;
        String expected = "Khong phai tam giac";
        String result = Triangle.classifyTriangle(side1, side2, side3);
        Assertions.assertEquals(expected, result);
    }
}