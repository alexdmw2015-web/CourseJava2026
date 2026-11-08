package ru.course.lesson01;

import java.util.Scanner;

public class Task003Coffee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Сколько стоит чашка кофе?");
        int coffeePrice = sc.nextInt();
        if (coffeePrice > 300) {
            System.out.println("Дороговато");
        }

        if (coffeePrice > 150 && coffeePrice <= 300) {
            System.out.println("Норм");
        }

        if (coffeePrice >= 80 && coffeePrice <= 150) {
            System.out.println("Дешево");
        }

        if (coffeePrice < 80) {
            System.out.println("А это в рублях? А это вообще кофе?");
        }
        sc.close();
    }
}