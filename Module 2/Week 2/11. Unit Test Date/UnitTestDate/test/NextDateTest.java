import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class NextDateTest {

    @Test
    void testFindNextDate_Day1_Month1_Year2018() {
        int day = 1;
        int month = 1;
        int year = 2018;
        LocalDate expected = LocalDate.of(2018, 1, 2);
        LocalDate result = NextDate.findNextDate(year, month, day);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFindNextDate_Day31_Month1_Year2018() {
        int day = 31;
        int month = 1;
        int year = 2018;
        LocalDate expected = LocalDate.of(2018, 2, 1);
        LocalDate result = NextDate.findNextDate(year, month, day);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFindNextDate_Day30_Month4_Year2018() {
        int day = 30;
        int month = 4;
        int year = 2018;
        LocalDate expected = LocalDate.of(2018, 5, 1);
        LocalDate result = NextDate.findNextDate(year, month, day);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFindNextDate_Day28_Month2_Year2018() {
        int day = 28;
        int month = 2;
        int year = 2018;
        LocalDate expected = LocalDate.of(2018, 3, 1);
        LocalDate result = NextDate.findNextDate(year, month, day);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFindNextDate_Day29_Month2_Year2020() {
        int day = 29;
        int month = 2;
        int year = 2020;
        LocalDate expected = LocalDate.of(2020, 3, 1);
        LocalDate result = NextDate.findNextDate(year, month, day);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFindNextDate_Day31_Month12_Year2018() {
        int day = 31;
        int month = 12;
        int year = 2018;
        LocalDate expected = LocalDate.of(2019, 1, 1);
        LocalDate result = NextDate.findNextDate(year, month, day);
        Assertions.assertEquals(expected, result);
    }
}