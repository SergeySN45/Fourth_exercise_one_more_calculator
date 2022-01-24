package Operations;

public abstract class Operations {
    private String nameOperation;
    public abstract String getNameOperation();
    public abstract double calculate(double a, double b) throws Exception;
}