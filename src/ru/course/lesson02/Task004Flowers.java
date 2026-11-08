package ru.course.lesson02;
// https://acmp.ru/index.asp?main=task&id_task=504
// Подключения сканера

import java.util.Scanner;

public class Task004Flowers {
    public static void main(String[] args) {
        // Инициализация сканера
        Scanner sc = new Scanner(System.in);
        // Инициализация массива с цветами
        char[] flowers = {'G', 'C', 'V'};

        // Количество дней
        System.out.print("Введите количество дней от 1 до 1000: ");
        int K = sc.nextInt();
        for (int day = 0; day < K; day++) {
            char temporary = flowers[1];
                flowers[1] = flowers[2];
                flowers[2] = temporary;
                temporary = flowers[0];
                flowers[0] = flowers[1];
                flowers[1] = temporary;
        }
        for (int e = 0; e < flowers.length; e++) {
            System.out.print(flowers[e]);
        }
        sc.close();
    }
}
