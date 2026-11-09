package ru.course.lesson02;
// https://acmp.ru/index.asp?main=task&id_task=521
import java.util.Scanner;
public class Task006Solitaire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalSteps = 0;
        System.out.print("Введите через пробел число карт в первой и в последней колоде: ");
        int p = sc.nextInt();
        int k = sc.nextInt();
        for (int i = p; i <= k; i++) {
            int steps = 0;
            int n = i;
            while (n != 2) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = n * 3 + 1;
                }
                steps++;
                if (steps > 1000) {
                    System.out.print(0);
                    return;
                }
            }
            totalSteps += steps;
        }
        System.out.print("Пасьянс сложился за " + totalSteps + " ходов.");
    }
}
