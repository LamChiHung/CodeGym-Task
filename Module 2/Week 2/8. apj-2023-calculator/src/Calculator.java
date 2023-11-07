public class Calculator {
    public static final java.lang.String ADDITION = "+";
    public static final java.lang.String SUBTRACTION = "-";
    public static final java.lang.String MULTIPLICATION = "*";
    public static final java.lang.String DIVISION = "/";

    public static int calculate(int firstOperand, int secondOperand, char operator) {
        switch (operator) {
            case ADDITION:
                return firstOperand + secondOperand;
            case SUBTRACTION:
                return firstOperand - secondOperand;
            case MULTIPLICATION:
                return firstOperand * secondOperand;
            case DIVISION:
                if (secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
