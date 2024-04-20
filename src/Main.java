import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите логическое выражение");
        String input = in.nextLine();
        String[] splitInput = input.split(" ");
        if (splitInput.length > 3)
            System.out.println("Формат математичсекой операции не удовлетворяет заданию");
        else if (splitInput.length < 3)
            System.out.println("Строка не является математической операцией");
        else {
            int num1 = 0, num2 = 0;
            String [] rome = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX"};
            boolean isRomeNum1 = false, isRomeNum2 = false;
            for (int i=0; i<10; i++){
                if (splitInput[0].equals(rome[i])) {
                    num1 = i + 1;
                    isRomeNum1 = true;
                }
                if (splitInput[2].equals(rome[i])) {
                    num2 = i + 1;
                    isRomeNum2 = true;
                }
            }
            if (!isRomeNum1 & isRomeNum2 | isRomeNum1 & !isRomeNum2)
                System.out.println("Используются  одновременно разные системы счисления");
            else {
                if (!isRomeNum1 & !isRomeNum2) {
                    num1 = Integer.parseInt(splitInput[0]);
                    num2 = Integer.parseInt(splitInput[2]);
                }
                if ((num1 < 1) | (num1 > 10) | (num2 < 1) | (num2 > 10))
                    System.out.println("Недопустимое значение переменной");
                else {
                    int output;
                    switch (splitInput[1]) {
                        case "+":
                            output = num1 + num2;
                            if (isRomeNum1 & isRomeNum2)
                                System.out.println(rome[output - 1]);
                            else
                                System.out.println(output);
                            break;
                        case "-":
                            output = num1 - num2;
                            if (isRomeNum1 & isRomeNum2)
                                if (output < 0)
                                    System.out.println("Отрицательный результат - в римской системе нет отрицательных чистел");
                                else
                                    System.out.println(rome[output - 1]);
                            else
                                System.out.println(output);
                            break;
                        case "*":
                            output = num1 * num2;
                            if (isRomeNum1 & isRomeNum2)
                                System.out.println(rome[output - 1]);
                            else
                                System.out.println(output);
                            break;
                        case "/":
                            output = num1 / num2;
                            if (isRomeNum1 & isRomeNum2)
                                System.out.println(rome[output - 1]);
                            else
                                System.out.println(output);
                            break;
                        default:
                            System.out.println("Вы ввели неверную операцию");
                    }
                }
            }
        }
    }
}
