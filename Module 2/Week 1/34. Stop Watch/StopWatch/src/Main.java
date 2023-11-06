import java.sql.Array;

public class Main {
    public static void main(String[] args) {
        StopWatch s = new StopWatch();
        s.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println("alo");
        }
        s.stop();
        System.out.println(s.getElapsedTime());
    }
}