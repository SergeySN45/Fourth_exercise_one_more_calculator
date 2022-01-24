import Operations.Addition;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SipmleCalculator calculator1 = new SipmleCalculator();

        System.out.println(calculator1.showAvalibleOperations());
        System.out.println(calculator1.showCurrentValues());
        //Выбираем операцию
        System.out.println("Choose operation:");
        try {
            calculator1.setCurrentOperaion(inputInt(scanner));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("It has been choosen " + calculator1.getNameCurrentOperation() + " operation");

        System.out.println("Enter first number:");
        calculator1.setOperandA(inputDouble(scanner));

        System.out.println("Enter second number:");
        calculator1.setOperandB(inputDouble(scanner));

        try {
            System.out.println("Result is " + calculator1.calculate());
        } catch (Exception e ) {
            System.out.println("You can't do " + calculator1.getNameCurrentOperation() + " because trying " + e.getMessage());
        }
    }

    //Функция для проверки соответсвия вводимых данных типу double
    private static double inputDouble(Scanner scanner) {
        double entered;
        while (!scanner.hasNextDouble()) {
            System.out.println(scanner.next() + " isn't double, try again!");
        }
        entered = scanner.nextDouble();

        return entered;
    }

    //Функция для проверки соответсвия вводимых данных типу integer
    private static int inputInt(Scanner scanner) {
        int entered;
        while (!scanner.hasNextInt()) {
            System.out.println(scanner.next() + " isn't Integer, try again!");
        }
        entered = scanner.nextInt();

        return entered;
    }
}
