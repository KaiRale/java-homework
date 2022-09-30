package hm3;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        //Считать с консоли количество тарелок и моющего средства.
        //
        //Моющее средство расходуется из расчета 0.5 на 1 тарелку (за один раз расходуется 0.5 стредства и 1 тарелка).
        //
        //В цикле выводить сколько моющего средства осталось после мытья каждой тарелки.
        //
        //После цыкла вывести сколько тарелок и моющего средства осталось.
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of plates");
        int platesCount = input.nextInt();

        System.out.println("Enter the amount of detergent");
        double detergentAmount = input.nextDouble();

        while (platesCount >= 1 && (detergentAmount / 0.5) >= 1) {
            platesCount--;
            detergentAmount -= 0.5;

            System.out.println("Remaining detergent: " + detergentAmount);
        }

        System.out.println("Remaining plates: " + platesCount);
        System.out.println("Remaining detergent: " + detergentAmount);

        // Программа загадывает число в диапазоне [1;9]
        //        Пользователь вводит число с клавиатуры
        //        Программа в зависимости от введенного числа выводит в консоль следующее:
        //        "загаданное число больше"
        //        "загаданное число меньше"
        //        "Вы угадали" (программа завершает работу)
        //        Если введен 0, выввести "выход из программы" (программа завершает работу)
        int start = 1, end = 9;
        int programNumber = (int) (Math.random() * (end - start + 1)) + start;

        System.out.println("Try to guess the number");

        while (true) {
            int tryNumber = input.nextInt();

            if (tryNumber == 0) {
                System.out.println("Ending the program");
                break;
            }
            if (programNumber == tryNumber) {
                System.out.println("You guessed it!");
                break;
            }
            if (programNumber > tryNumber) {
                System.out.println("Our number is bigger");
                continue;
            }
            System.out.println("Our number is smaller");
        }

        //Задача на использование любого цикла (выберите сами) ***
        //
        //    Пользователь загадывает число в диапазоне от [2 до 100]
        //    Программа пытается его угадать (используйте метод бинарного поиска, т.е деление отрезка на 2).
        //    Программа может задавать пользователю вопросы: Число равно ...?, Число больше ...?
        //    и в зависимоти от ответа пользователя принимать решения.
        //    Вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА

        start = 2;
        end = 100;

//        костыль чтобы вписать границы диапозона в отрезок
//        start -= 1;
//        end += 1;
        while (true) {
            int programVariant = start + (end - start) / 2;

            System.out.println("Is your number equals " + programVariant + "?");
            int answer = input.nextInt();

            if (answer != 1 && answer != 0) {
                System.out.println("Invalid data. Allowed 1 or 0.");
                continue;
            }

            if (answer == 1) {
                System.out.println("I beat you, silly human!");
                break;
            } else {
                if (start == end){
                    System.out.println("You lied to me somewhere, I don't want to play with you anymore.");
                    break;
                }

                System.out.println("Is your number bigger when " + programVariant + "?");
                answer = input.nextInt();

                if (answer == 1) {
                    // второй вариант костыля чтобы вписать границы диапозона в отрезок
                    // изначально start = programVariant;
                    if (end - programVariant == 1) start += 2;
                    else start = programVariant;
                } else {
                    end = programVariant;
                }
            }
        }

    }
}
