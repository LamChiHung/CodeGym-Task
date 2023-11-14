public class Main {
    public static void main(String[] args) throws InterruptedException {
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();
        evenThread.start();
        evenThread.join();
        oddThread.start();
    }
}