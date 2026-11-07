package ru.course.lesson01;

import java.util.Scanner;

public class Task002threeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = sc.nextInt();

        System.out.print("Введите второе число: ");
        int b = sc.nextInt();

        System.out.print("Введите третье число: ");
        int c = sc.nextInt();

        int ab = a - b;
        int ac = a - c;
        int ba = b - a;
        int bc = b - c;
        int ca = c - a;
        int cb = c - b;


        System.out.println();
        System.out.println("Введённые числа: a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("a - b = " + a + " - " + b + " = " + ab);
        System.out.println("a - c = " + a + " - " + c + " = " + ac);
        System.out.println("b - c = " + b + " - " + c + " = " + bc);
        System.out.println("b - a = " + b + " - " + a + " = " + ba);
        System.out.println("c - a = " + c + " - " + a + " = " + ca);
        System.out.println("c - b = " + c + " - " + b + " = " + cb);

        sc.close();
    }
}
