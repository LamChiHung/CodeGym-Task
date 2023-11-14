public class Count implements Runnable {
    private Thread thread;

    public Count() {
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Thread getThread() {
        return this.thread;
    }
}
