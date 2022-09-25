package hm1;

public class Homework {
    public static void main(String[] args) {
        //Даны длина, ширина и высота прямоугольного параллелепипеда.
        // Найти и вывести в консоль его площадь.
        int w = 3, h = 4, l = 7;
        int s = 2 * (w * h + h * l + w * l);
        System.out.println(s);

        // Дано целое число. Найти и вывести в консоль данное число в кубе.
        int num = 3;
        int result = num * num * num;
        System.out.println(result);

        //Даны две переменные типа double: время (в часах) и расстояние (в километрах). Найти
        // и вывести в консоль скорость, выраженную в метрах в секунду.
        int time = 10;
        int distance = 130;
        double speed = (double) (distance * 1000) / (time * 3600);
        System.out.println("speed");
        System.out.println(speed);
    }
}
