import org.junit.Assert;
import org.junit.Test;

public class AbsNumberCalculatorTest {

    @org.junit.jupiter.api.Test

    @Test
    public void testFindAbs0() {
        int number = 0;
        int expected = 0;
        int result = AbsNumberCalculator.findAbs(number);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testFindAbs1() {
        int number = 1;
        int expected = 1;
        int result = AbsNumberCalculator.findAbs(number);
        Assert.assertEquals(expected, result);
    }

    public void testFindAbsNegative1() {
        int number = - 1;
        int expected = 1;
        int result = AbsNumberCalculator.findAbs(number);
        Assert.assertEquals(expected, number);
    }
}