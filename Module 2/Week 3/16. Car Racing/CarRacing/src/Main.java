public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Car1", 100);
        Car car2 = new Car("Car2", 100);
        Car car3 = new Car("Car3", 100);

        Thread thread1 = new Thread(car1);
        Thread thread2 = new Thread(car2);
        Thread thread3 = new Thread(car3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}