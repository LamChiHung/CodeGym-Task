import java.util.Random;

public class Car implements Runnable {
    private int speed;
    private int km;
    private int des;
    private String name;

    private long starTime;
    private long stopTime;
    private String before;
    private String after;

    public Car(String name, int des) {
        this.name = name;
        this.km = 0;
        this.des = des;
    }

    @Override
    public void run() {
        this.starTime = System.currentTimeMillis();
        while (km < des) {
            before = "";
            after = "";
            for (int i = 0; i < km; i++) {
                before += "=";
            }
            for (int i = km; i < des; i++) {
                after += "-";
            }
            System.out.println(this.name + " :|" + before + "o" + after + "|" + this.km + "KM");
            this.speed = (new Random()).nextInt(20);
            km += speed;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.stopTime = System.currentTimeMillis();
        System.out.println(this.name + " finished at: " + (this.stopTime - this.starTime));
    }
}
