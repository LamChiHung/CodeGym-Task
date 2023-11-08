import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    @Test
    void testFizzBuzz_1() {
        int number = 1;
        String expected = "mot";
        String result = FizzBuzz.fizzBuzz(number);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFizzBuzz_11() {
        int number = 11;
        String expected = "mot mot";
        String result = FizzBuzz.fizzBuzz(number);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFizzBuzz_negative1() {
        int number = - 1;
        String expected = "Input number smaller than 100 and greater than 0";
        String result = FizzBuzz.fizzBuzz(number);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFizzBuzz_101() {
        int number = 101;
        String expected = "Input number smaller than 100 and greater than 0";
        String result = FizzBuzz.fizzBuzz(number);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFizzBuzz_50() {
        int number = 50;
        String expected = "nam khong";
        String result = FizzBuzz.fizzBuzz(number);
        Assertions.assertEquals(expected, result);
    }
}