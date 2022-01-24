package Operations;

public class Multiplication extends Operations {
    private final String nameOperation = "Multiplication";

    @Override
    public String getNameOperation() {
        return nameOperation;
    }

    @Override
    public double calculate(double a, double b) { return a * b; }
}
