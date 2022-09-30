package hm2;

public class Homework {
    public static void main(String[] args) {
        //Дан номер месяца, например int month = 5. В зависимости от данного значения вывести в консоль время года
        int month = 6;

        if (month <= 0 || month > 12) {
            System.out.println("Invalid data");
        } else if (month == 12 || month < 3 ) {
            System.out.println("Spring");
        } else if (month < 6) {
            System.out.println("Summer");
        } else if (month < 9) {
            System.out.println("Autumn");
        } else if (month < 12)  {
            System.out.println("Winter");
        }

        // Дана переменная sum - сумма покупки и переменна saleCode - номер купона.
        //
        //    Если номер купона равен 4525 - вывести сумму с учетом скидки 30%
        //    Если номер купона равен 6424 или 7012 - вывести сумму с учетом скидки 20%
        //    Если номер купона равен 7647 или 9011 или 6612 - вывести сумму с учетом скидки 10%
        //    В остальных случаях скидка не предусмотрена, вывесть полную стоимость покупки.

        int sum = 797, saleCode = 9011;

        switch (saleCode) {
            case 4525 -> System.out.println("Price: " + (sum * 0.7));
            case 6424, 7012 -> System.out.println("Price: " + (sum * 0.8));
            case 7647, 9011, 6612 -> System.out.println("Price: " + (sum * 0.9));
            default -> System.out.println("Price: " + sum);
        }

        // Дана целочисленная переменная count - количество верных ответов. В зависимости от значения
        // этой переменной вывести в консоль оценку: 100 - 90 правильных ответов - отлично 89 - 60
        // правильных ответов - хорошо 59 - 40 правильных ответов - удовлетворительно 39 - 0 правильных
        // ответов - попробуйте в следующий раз

        int count = 50;

        if (count >= 90 && count <= 100) {
            System.out.println("Perfect");
        } else if (count < 90 && count >= 60) {
            System.out.println("Good");
        } else if (count < 60 && count >= 40) {
            System.out.println("Satisfactory");
        } else if (count < 40 && count >= 0) {
            System.out.println("Try again another time");
        } else {
            System.out.println("Invalid data");
        }

        // Самостоятельно разобрать как работает Math.random() и написать код, который будет проверять
        // попало ли случайно сгенерированное целое число из отрезка [10;500] в интервал (25;200) и
        // выводить результат в консоль.
        int randomStart = 10, randomEnd = 500;
        int randomNumber = (int) ((Math.random() * (randomEnd - randomStart + 1)) + randomStart);

        if (randomNumber > 25 && randomNumber < 200) {
            System.out.println("The number " + randomNumber + " is in the range (25;200)");
        } else {
            System.out.println("The number " + randomNumber + " is not in the range (25;200)");
        }

        // Даны переменные age - возраст и exp - опыт работы.
        //
        // Если значение переменной age больше 100, вывести в консоль "Мы Вам перезвоним".
        // В противном случае перейти к проверке exp. Если значение exp меньше 5, вывести в консоль
        // "Вы подходите на должность стажера". Если значение exp больше или равно 5, вывести в консоль
        // "Вы подходите на должность разработчика".
        int age = 57, exp = 25;

        if (age > 100) {
            System.out.println("We will call you back");
        } else if (exp < 5){
            System.out.println("You are qualified to be an intern");
        } else if (exp >= 5){
            System.out.println("You are qualified to be a developer");
        }
    }
}
