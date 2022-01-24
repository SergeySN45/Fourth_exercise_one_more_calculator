package Operations;

public class Division extends Operations {
    private final String nameOperation = "Division";

    @Override
    public String getNameOperation() {
        return nameOperation;
    }

    @Override
    public double calculate(double a, double b) { return a / b; }
}
