package ru.course.lesson02;
// https://acmp.ru/index.asp?main=task&id_task=233
// Подключения сканера

import java.util.Scanner;

public class Task003Bus {
    public static void main(String[] args) {
// Инициализация сканера и исходных данных
        Scanner sc = new Scanner(System.in);
        int busHeight = 437;
        boolean crashed = false;
// Ввод данных от пользователя
        System.out.println("Введите количество мостов.");
        int bridgeCount = sc.nextInt();
        int[] bridgeHeights = new int[bridgeCount];
        System.out.println("Введите высоту " + bridgeCount + " мостов через пробел от 1 до 1000см");
        for (int i = 0; i < bridgeCount; i++) {
            bridgeHeights[i] = sc.nextInt();
        }
// Обработка результатов
        int k = 0; // счетчик количества мостов
        int crashIndex = -999; // мост, где случилась авария
        while (k < bridgeCount && !crashed) {
            if (busHeight >= bridgeHeights[k]) {
                crashed = true;
                crashIndex = k+1;
            }
            k++;
        }

        // Вывод результатов
        if (crashed) {
            System.out.println("Crash " + crashIndex);
        } else {
            System.out.println("No crash");
        }
        sc.close();
    }
}
