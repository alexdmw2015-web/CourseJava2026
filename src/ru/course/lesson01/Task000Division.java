package ru.course.lesson01;

import java.util.Scanner;

public class Task000Division {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите два числа через пробел: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        float c = (float) ((double) a / (double) b);
        System.out.printf("%.2f%n", c);
    }
}
