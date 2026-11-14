package ru.course.lesson01;

import java.util.Scanner;

public class Task000Division {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите два числа через пробел: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = a / b;
        System.out.printf("%.2f%n", c);
        System.out.print(c);
    }
}
