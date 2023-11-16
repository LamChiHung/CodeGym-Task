public class Client {
    FileCalculator fileCalculator;

    public void printcalculatorFile(String path) {
        fileCalculator = new FileCalculatorAdapter();
        System.out.println(fileCalculator.calculatorFile(path));
    }
}
