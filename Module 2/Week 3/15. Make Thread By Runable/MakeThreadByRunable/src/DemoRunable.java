public class DemoRunable implements Runnable {
    private Thread thread;
    private String threadName;

    public DemoRunable(Thread thread, String threadName) {
        this.thread = thread;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Running: " + threadName);
        for (int i = 5; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread: " + threadName + " exit");
    }

    public void start() {
        System.out.println("Starting: " + threadName);
        if (this.thread == null) {
            this.thread = new Thread(this, threadName);
        }
        thread.start();
    }
}
