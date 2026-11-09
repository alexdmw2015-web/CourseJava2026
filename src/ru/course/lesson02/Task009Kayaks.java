package ru.course.lesson02;

import java.util.Scanner;
import java.util.Arrays;

public class Task009Kayaks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Чтение N (количество участников) и D (грузоподъёмность байдарки) ---
        System.out.print("Введите N и D через пробел: ");

        if (!sc.hasNextInt()) {
            System.out.println("Ошибка: ожидалось целое число N");
            sc.close();
            return;
        }
        int n = sc.nextInt();

        if (!sc.hasNextInt()) {
            System.out.println("Ошибка: ожидалось целое число D");
            sc.close();
            return;
        }
        int capacity = sc.nextInt();

        // Проверка N по условию: 1 ≤ N ≤ 15000
        if (n < 1 || n > 15000) {
            System.out.println("Ошибка: N должно быть в диапазоне 1..15000");
            sc.close();
            return;
        }

        // Проверка D по условию: 1 ≤ D ≤ 15000
        if (capacity < 1 || capacity > 15000) {
            System.out.println("Ошибка: D должно быть в диапазоне 1..15000");
            sc.close();
            return;
        }

        // --- Чтение веса участников ---
        int[] weights = new int[n];
        System.out.print("Введите вес для " + n + " участников через пробел: ");

        for (int i = 0; i < n; i++) {
            if (!sc.hasNextInt()) {
                System.out.println("Ошибка: ожидалось " + n + " целых чисел, получено " + i);
                sc.close();
                return;
            }
            weights[i] = sc.nextInt();

            // Проверка веса по условию: 1 ≤ Mi ≤ D
            if (weights[i] < 1 || weights[i] > capacity) {
                System.out.println("Ошибка: вес участника #" + (i + 1)
                        + " должен быть в диапазоне 1.." + capacity);
                sc.close();
                return;
            }
        }

        // --- Обработка: минимальное число байдарок (два указателя) ---
        // Сортируем веса по возрастанию
        Arrays.sort(weights);

        int left = 0;              // указатель на самого лёгкого
        int right = n - 1;         // указатель на самого тяжёлого
        int kayakCount = 0;        // счётчик использованных байдарок

        while (left <= right) {
            // Если самый лёгкий помещается вместе с самым тяжёлым —
            // берём обоих в одну байдарку
            if (weights[left] + weights[right] <= capacity) {
                left++;
            }
            // Самый тяжёлый всегда занимает байдарку (один или с лёгким)
            right--;
            kayakCount++;
        }

        // --- Вывод результата ---
        System.out.println(kayakCount);

        sc.close();
    }
}
