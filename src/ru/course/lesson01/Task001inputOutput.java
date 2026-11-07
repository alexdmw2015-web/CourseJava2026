package ru.course.lesson01;

import java.util.Scanner;

public class Task001inputOutput {

    public static void main() { // Обязательная магия, указывающая начало программы

        Scanner scanner = new Scanner(System.in);
        int count = 3;
        System.out.println("Введите " + count + " числа через пробел!");

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println("Вы ввели числа " + a + ", " + b + ", " + c);

        scanner.close();
    }
}
