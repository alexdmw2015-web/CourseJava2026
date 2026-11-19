package ru.course.lesson02;

import java.util.ArrayList;
import java.util.Arrays;

public class HairBusiness {
    static void main(String[] args) {
        // Ввод количества дней
        int n = Integer.parseInt(IO.readln("Введите количество дней: "));
        // Ввод цены в каждый день
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = Integer.parseInt(IO.readln());
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        // Поиск макс
        for (int i = n - 1; i >= 0; i--) {
            if (days[i] > max) {
                max = days[i];
            }
            sum += max;
        }

        // Вывод макс
        System.out.println(sum);
    }
}
