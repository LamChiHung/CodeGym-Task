import java.time.LocalDate;

public class NextDate {
    public static LocalDate findNextDate(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.plusDays(1);
    }
}
