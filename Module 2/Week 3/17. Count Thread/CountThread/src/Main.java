import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        while (count.getThread().isAlive()) {
            System.out.println("Main thread still alive");
            Thread.sleep((new Random()).nextInt(1000));
        }
        System.out.println("Main Thread dead");
    }
}