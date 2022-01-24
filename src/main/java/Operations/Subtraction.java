package Operations;

public class Subtraction extends Operations {
    private final String nameOperation = "Subtraction";

    @Override
    public String getNameOperation() {
        return nameOperation;
    }

    @Override
    public double calculate(double a, double b) { return a - b; }
}
