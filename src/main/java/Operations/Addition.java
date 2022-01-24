package Operations;

public class Addition extends Operations {
    private final String nameOperation = "Addition";

    @Override
    public String getNameOperation() {
        return nameOperation;
    }

    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}
