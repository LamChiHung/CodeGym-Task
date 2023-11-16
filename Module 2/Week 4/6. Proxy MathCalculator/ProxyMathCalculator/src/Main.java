public class Main {
    public static void main(String[] args) {
        Calculator calculator = new ProxyMathCalculator();
        System.out.println(calculator.add(1, 2));
        System.out.println(calculator.sub(1, 2));
//        System.out.println(calculator.sub(12, 2));
    }
}