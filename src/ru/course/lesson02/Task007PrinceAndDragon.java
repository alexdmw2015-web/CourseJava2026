package ru.course.lesson02;

import java.util.Scanner;

public class Task007PrinceAndDragon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Ввод исходных данных
        System.out.print("Введите исходные данные через пробел: ");
        int N = sc.nextInt(); // Число срубаемых голов за раз
        int M = sc.nextInt(); // Число голов дракона
        int K = sc.nextInt(); // Число регенерируемых голов за раз
        int strikes = 0;
        boolean possible = true;

        // Проверка
        while (M > 0) {
            M = M - N;
            strikes++;
            if (M > 0) {
                if (N <= K) {
                    possible = false;
                    break;
                }
                M = M + K;
            }
        }

        // Вывод результатов

            System.out.print(possible ? strikes : "NO");

        sc.close();
    }
}
