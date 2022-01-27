import Operations.Addition;
import Operations.Division;
import Operations.Multiplication;
import Operations.Subtraction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    Addition addition;
    Subtraction subtraction;
    Division division;
    Multiplication multiplication;

    @Before
    public void setUp() {
        addition = new Addition();
        subtraction = new Subtraction();
        division = new Division();
        multiplication = new Multiplication();
    }

    //Тест Операции сложение
    @Test
    public void testAddition() {
        double a = 5;
        double b = 1;
        Assert.assertEquals(6, addition.calculate(a,b), 0.0001);
    }

    //Тест Операции сложение
    @Test
    public void testAdditionZero() {
        double a = 5;
        double b = -0;
        Assert.assertEquals(5, addition.calculate(a,b), 0.0001);
    }

    //Тест Операции вычитания
    @Test
    public void testSubtraction() {
        double a = 10;
        double b = 3;
        Assert.assertEquals(7, subtraction.calculate(a,b), 0.0001);
    }

    //Тест Операции вычитания
    @Test
    public void testSubtraction2() {
        double a = 50;
        double b = 50;
        Assert.assertEquals(0, subtraction.calculate(a,b), 0.0001);
    }

    //Тест Операции умножения
    @Test
    public void testMultiplication() {
        double a = 0.1;
        double b = 0.1;
        Assert.assertEquals(0.01, multiplication.calculate(a,b), 0.0001);
    }

    //Тест Операции умножения
    @Test
    public void testMultiplication2() {
        Multiplication multiplication = new Multiplication();
        double a = -0;
        double b = -15.111;
        Assert.assertEquals(0, multiplication.calculate(a,b), 0.0001);
    }

    //Тест Операции деление
    @Test(expected = ArithmeticException.class)
    public void testDivision() throws ArithmeticException {
        Division division = new Division();
        int a = 5;
        int b = 0;
        Assert.assertEquals(1, division.calculate(a,b), 0.0001);
    }

    //Тест Операции деление
    @Test
    public void testDivision2() throws ArithmeticException {
        Division division = new Division();
        int a = 9;
        int b = 3;
        Assert.assertEquals(3, division.calculate(a,b), 0.0001);
    }

    //Проверка кол-ва операций
    @Test
    public void testCalcCreate() throws Exception{
        SipmleCalculator calculator1 = new SipmleCalculator();
        Assert.assertEquals(4, calculator1.getCountOperation());
    }

    //Проверка кол-ва операций
    @Test
    public void testCalcOwnCreate() throws Exception{
        SipmleCalculator calculator1 = new SipmleCalculator(addition, subtraction, multiplication, division);
        Assert.assertEquals(4, calculator1.getCountOperation());
    }

    //Проверка кол-ва операций
    @Test
    public void testCalcOwnCreate2() throws Exception{
        SipmleCalculator calculator1 = new SipmleCalculator(addition, subtraction, division);
        Assert.assertEquals(3, calculator1.getCountOperation());
    }

    //Проверка кол-ва операций
    @Test
    public void testCalcOwnCreate3() throws Exception{
        SipmleCalculator calculator1 = new SipmleCalculator(addition, subtraction, subtraction, addition, subtraction, subtraction, addition, subtraction, subtraction);
        Assert.assertEquals(2, calculator1.getCountOperation());
    }

    //Проверка получения названий операций
    @Test
    public void testCalcShowOperations() {
        SipmleCalculator calculator1 = new SipmleCalculator();
        String show = "This calculator can perform the following operations: \n" +
                "1 : Addition\n" +
                "2 : Subtraction\n" +
                "3 : Division\n" +
                "4 : Multiplication\n";
        Assert.assertEquals(show, calculator1.showAvalibleOperations());
    }

    //Проверка получения выбранной в данный момент операций
    @Test
    public void testCalcGetCurrentOperation() {
        SipmleCalculator calculator1 = new SipmleCalculator();
        Assert.assertEquals(1, calculator1.getCurrentOperaion());
    }

    //Проверка получения выбранной в данный момент операций
    @Test
    public void testCalcSetGetCurrentOperation() throws Exception {
        SipmleCalculator calculator1 = new SipmleCalculator();
        calculator1.setCurrentOperaion(2);
        Assert.assertEquals(2, calculator1.getCurrentOperaion());
    }

    //Проверка получения выбранной в данный момент операций
    @Test(expected = Exception.class)
    public void testCalcSetGetCurrentOperation2() throws Exception {
        SipmleCalculator calculator1 = new SipmleCalculator();
        calculator1.setCurrentOperaion(5);
        Assert.assertEquals(0, calculator1.getCurrentOperaion());
    }

    //Проверка получения названия выбранной в данный момент операций
    @Test
    public void testCalcGetCurrentNameOperatin() {
        SipmleCalculator calculator1 = new SipmleCalculator();
        Assert.assertEquals("Addition", calculator1.getNameCurrentOperation());
    }

    //Проверка получения названия выбранной в данный момент операций
    @Test
    public void testCalcGetCurrentNameOperatin2() {
        SipmleCalculator calculator1 = new SipmleCalculator(multiplication);
        Assert.assertEquals("Multiplication", calculator1.getNameCurrentOperation());
    }

    //Проверка получения названия выбранной в данный момент операций
    @Test
    public void testCalcGetCurrentNameOperatin3() throws Exception {
        SipmleCalculator calculator1 = new SipmleCalculator(multiplication, division);
        calculator1.setCurrentOperaion(2);
        Assert.assertEquals("Division", calculator1.getNameCurrentOperation());
    }

    //Тест установки значения первого операнда
    @Test
    public void testCalcSetOperatdA() {
        SipmleCalculator calculator1 = new SipmleCalculator();
        calculator1.setOperandA(-0.0025);
        Assert.assertEquals(-0.0025, calculator1.getOperandA(), 0.0001);
    }

    //Тест установки значения второго операнда
    @Test
    public void testCalcSetOperatdB() {
        SipmleCalculator calculator1 = new SipmleCalculator();
        calculator1.setOperandB(-512.0927);
        Assert.assertEquals(-512.0927, calculator1.getOperandB(), 0.0001);
    }

    //Тест получения значения первого операнд
    @Test
    public void testCalcGetOperatdA() {
        SipmleCalculator calculator1 = new SipmleCalculator();
        Assert.assertEquals(0, calculator1.getOperandA(), 0.0001);
    }

    //Тест получения значения первого операнд
    @Test
    public void testCalcGetOperatdA2() {
        SipmleCalculator calculator1 = new SipmleCalculator();
        calculator1.setOperandA(15.08);
        Assert.assertEquals(15.08, calculator1.getOperandA(), 0.0001);
    }

    //Тест получения значения второго операнд
    @Test
    public void testCalcGetOperatdB() {
        SipmleCalculator calculator1 = new SipmleCalculator();
        Assert.assertEquals(0, calculator1.getOperandB(), 0.0001);
    }

    //Тест получения значения второго операнд
    @Test
    public void testCalcGetOperatdB2() {
        SipmleCalculator calculator1 = new SipmleCalculator();
        calculator1.setOperandB(15.08);
        Assert.assertEquals(15.08, calculator1.getOperandB(), 0.0001);
    }

    //Тест получения текущих значений и выбранной операции
    @Test
    public void testCalcCurrentValues() {
        SipmleCalculator calculator1 = new SipmleCalculator();
        String str = "Value A = 0.0,\n" +
                "Value B = 0.0,\n" +
                "current operation is Addition";
        Assert.assertEquals(str, calculator1.showCurrentValues());
    }

    //Тест получения текущих значений и выбранной операции
    @Test
    public void testCalcCurrentValues2() throws Exception {
        SipmleCalculator calculator1 = new SipmleCalculator();
        calculator1.setOperandA(5.1);
        calculator1.setOperandB(7.81);
        calculator1.setCurrentOperaion(2);
        String str = "Value A = 5.1,\n" +
                "Value B = 7.81,\n" +
                "current operation is Subtraction";
        Assert.assertEquals(str, calculator1.showCurrentValues());
    }

    //Тест выполнения операции калькулятором
    @Test
    public void testCalc() throws Exception{
        SipmleCalculator calculator1 = new SipmleCalculator();
        Assert.assertEquals(0, calculator1.calculate(), 0.0001);
    }

    //Тест выполнения операции калькулятором
    @Test
    public void testCalc2() throws Exception{
        SipmleCalculator calculator1 = new SipmleCalculator();
        calculator1.setOperandA(5.1);
        calculator1.setOperandB(7.81);
        Assert.assertEquals(12.91, calculator1.calculate(), 0.0001);
    }

    //Тест выполнения операции калькулятором
    @Test
    public void testCalc3() throws Exception{
        SipmleCalculator calculator1 = new SipmleCalculator();
        calculator1.setOperandA(9);
        calculator1.setOperandB(1);
        calculator1.setCurrentOperaion(4);
        Assert.assertEquals(9, calculator1.calculate(), 0.0001);
    }

    //Тест выполнения операции калькулятором
    @Test(expected = Exception.class)
    public void testCalc4() throws Exception{
        SipmleCalculator calculator1 = new SipmleCalculator();
        calculator1.setOperandA(9);
        calculator1.setOperandB(0);
        calculator1.setCurrentOperaion(3);
        Assert.assertEquals(9, calculator1.calculate(), 0.0001);
    }

}
