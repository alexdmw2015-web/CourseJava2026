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
/*
        for (int i = 0; i < bridgeHeights.length; i++) {
            if (BusHeight >= bridgeHeights[i]) {
                crashed = true;
                k = i + 1;
                break;
            }
        }
*/
        int k = 0; // счетчик количества мостов
        while (k < bridgeCount && !crashed) {
            if (busHeight >= bridgeHeights[k]) {
                crashed = true;
            }
            k++;
        }

        // Вывод результатов
        if (crashed) {
            System.out.println("Crash " + k);
        } else {
            System.out.println("No crash");
        }
        sc.close();
    }
}