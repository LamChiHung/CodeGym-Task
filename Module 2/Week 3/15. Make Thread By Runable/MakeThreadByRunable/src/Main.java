public class Main {
    public static void main(String[] args) {
        DemoRunable demoRunable1 = new DemoRunable(null, "A");
        demoRunable1.start();
        DemoRunable demoRunable2 = new DemoRunable(null, "B");
        demoRunable2.start();
        System.out.println("Main Thread end");
    }
}