package ru.course.lesson02;
// https://acmp.ru/index.asp?main=task&id_task=233
// Подключения сканера

import java.util.Scanner;

public class Task003bus {
    public static void main(String[] args) {
// Инициализация сканера и исходных данных
        Scanner sc = new Scanner(System.in);
        int maxBusHeight = 437;
        boolean crash = false;
        int k = -999;
// Ввод данных от пользователя
        System.out.println("Введите количество мостов.");
        int bridgeCount = sc.nextInt();
        int[] bridgeHeights = new int[bridgeCount];
        System.out.println("Введите высоту " + bridgeCount + " мостов через пробел от 1 до 1000см");
        for (int i = 0; i < bridgeCount; i++) {
            bridgeHeights[i] = sc.nextInt();
        }
// Обработка результатов
        for (int i = 0; i < bridgeHeights.length; i++) {
            if (maxBusHeight >= bridgeHeights[i]) {
                crash = true;
                k = i + 1;
                break;
            }
        }

        // Вывод результатов
        if (crash) {
            System.out.println("Crash " + k);
        } else {
            System.out.println("No crash");
        }
        sc.close();
    }
}
