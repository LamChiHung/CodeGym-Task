public class ProxyMathCalculator implements Calculator {
    double result;
    MathCalculator mathCalculator = new MathCalculator();

    @Override
    public double add(double a, double b) {
        if (a < 10 && b < 10) {
            return mathCalculator.add(a, b);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public double sub(double a, double b) {
        if (a < 10 && b < 10) {
            return mathCalculator.sub(a, b);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public double mul(double a, double b) {
        if (a < 10 && b < 10) {
            return mathCalculator.mul(a, b);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public double div(double a, double b) {
        if (b != 0) {
            return mathCalculator.div(a, b);
        } else {
            throw new ArithmeticException();
        }
    }
}
