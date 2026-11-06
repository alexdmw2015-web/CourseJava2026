package ru.course.lesson01;

import java.util.Scanner;

public class Task001_threeNumbers_v2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] prompts = {"первое", "второе", "третье"};
        int[] arr = new int[prompts.length];

        for (int i = 0; i < prompts.length; i++) {
            System.out.print("Введите " + prompts[i] + " число: ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int e = 0; e < arr.length; e++) {
                if (e != i) {
                    System.out.println("Разность " + arr[i] + " - " + arr[e] + " = " + (arr[i] - arr[e]));
                }
            }
        }

        sc.close();
    }
}
