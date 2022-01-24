package Operations;

public class Division extends Operations {
    private String nameOperation = "Division";

    @Override
    public String getNameOperation() {
        return nameOperation;
    }

    @Override
    public double calculate(double a, double b) throws Exception {
        if (b == 0) {
            throw new ArithmeticException("division by zero");
        } else {
            return a / b;
        }
    }
}
