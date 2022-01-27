import Operations.*;

import java.util.ArrayList;

public class SipmleCalculator{
    private ArrayList<Operations> operations = new ArrayList<>();
    private int currentOperaion = 0;
    private double operandA = 0;
    private double operandB = 0;

    //Конструктор калькулятора с обычными операциями
    SipmleCalculator () {
        operations.add(new Addition());
        operations.add(new Subtraction());
        operations.add(new Division());
        operations.add(new Multiplication());
    }

    //Конструктор калькулятора со своими операциями
    SipmleCalculator(Operations... operations) {
        for (Operations operation : operations) {
            this.add(operation);
        }
    }

    //Добавление операций в калькулятор, без повторений
    private void add(Operations operation) {
        boolean met = false;
        for (Operations someOperation : this.operations) {
            if (someOperation.getNameOperation() == operation.getNameOperation()) {
                met = true;
            }
        }
        if (!met) {
            this.operations.add(operation);
        }
    }

    //Список всех доступных операций в калькуляторе
    public String showAvalibleOperations() {
        String operationsInfo = "This calculator can perform the following operations: \n";
        for (int i = 0; i < operations.size(); i++) {
            operationsInfo += (i + 1) + " : " + operations.get(i).getNameOperation() + "\n";
        }
        return operationsInfo;
    }

    //Выбранный на данный момент номер операции
    public int getCurrentOperaion () {
        return this.currentOperaion + 1;
    }

    //Устанавливаем номер операции, если возможно, иначе оставляем текущий номер операции
    public void setCurrentOperaion (int operation) throws Exception {
        if ((operation >= 1) && (operation <= getCountOperation())) {
            this.currentOperaion = operation - 1;
        }else {
            throw new Exception("The entered value doesn't correspond to the available operations");
        }
    }

    //Название текущей операции
    public String getNameCurrentOperation() {
        return this.operations.get(currentOperaion).getNameOperation();
    }

    //Получить значение первого операнда
    public double getOperandA() {
        return operandA;
    }

    //Задать значение первого операнда
    public void setOperandA(double operandA) {
        this.operandA = operandA;
    }

    //Получить значение второго операнда
    public double getOperandB() {
        return operandB;
    }

    //Задать значение второго операнда
    public void setOperandB(double operandB) {
        this.operandB = operandB;
    }

    //Текущее значения переменных и выбранная операция
    public String showCurrentValues() {
        return "Value A = " + operandA + ",\nValue B = " + operandB + ",\ncurrent operation is " + getNameCurrentOperation();
    }

    //получение количества доступных в калькуляторе операций
    public int getCountOperation() {
        return operations.size();
    }

    //Рассчёт на основе имеющихся данных
    public double calculate() throws Exception {
            return operations.get(currentOperaion).calculate(operandA,operandB);
    }
}