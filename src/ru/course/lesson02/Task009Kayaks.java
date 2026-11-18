package ru.course.lesson02;
// https://acmp.ru/index.asp?main=task&id_task=869

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Task009Kayaks {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);

        // --- Чтение N (количество участников) и D (грузоподъёмность байдарки) ---
        int[] ND = getNumberOfPeopleAndBoatCapacity();

        // --- Чтение веса участников --
        ArrayList<Integer> weightsOfPeople = getWeights(ND[0]);

        //--- Обработка: минимальное число байдарок
        int kayakCount = getNumberOfKayaks(ND[1], weightsOfPeople);
        //--- Вывод результата
        IO.println(kayakCount);
    }

    public static int[] getNumberOfPeopleAndBoatCapacity() {
                String line = IO.readln("Введите кол-во участников похода и макс. грузоподъемность лодки через пробел: ");
        String[] parts = line.trim().split("\\s+");
        return new int[] {
                Integer.parseInt(parts[0]),   // n
                Integer.parseInt(parts[1])
        };
    }

//    public static int[] getWeights(int numberOfPeople) {
//        String line = IO.readln("Введите " + numberOfPeople + " весов через пробел: ");
//
//        String[] parts = line.trim().split("\\s+");
//        if (parts.length < numberOfPeople) {
//            IO.println("Ошибка: нужно " + numberOfPeople + " числа, получено " + parts.length);
//            return new int[0];
//        }
//        int[] weights = new int[numberOfPeople];
//
//        for (int i = 0; i < numberOfPeople; i++) {
//            weights[i] = Integer.parseInt(parts[i]);
//        }
//        return weights;
//    }

    public static ArrayList<Integer> getWeights(int numberOfPeople) {
        String line = IO.readln("Введите вес " + numberOfPeople + " человек через пробел: ");

        String[] parts = line.trim().split("\\s+");
        if (line.trim().isEmpty() || parts.length != numberOfPeople) {
            IO.println("Ошибка: нужно " + numberOfPeople + " чисел, получено " + parts.length);
            return new ArrayList<>();
        }

        ArrayList<Integer> weights = new ArrayList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            weights.add(Integer.parseInt(parts[i]));
        }
        return weights;                          // ← возврат
    }

    // --- Версия для int[] (основная логика) ---
    public static int getNumberOfKayaks(int maxLoad, int[] weights) {
        Arrays.sort(weights);                 // ⚠️ мутирует исходный массив
        int left = 0;
        int right = weights.length - 1;
        int kayakCount = 0;

        while (left <= right) {
            if (weights[left] + weights[right] <= maxLoad) {
                left++;
            }
            right--;
            kayakCount++;
        }
        return kayakCount;
    }

    // --- Версия с перегрузкой функции для ArrayList ---
    public static int getNumberOfKayaks(int maxLoad, ArrayList<Integer> weights) {
        // Копируем Arraylist, чтобы он не мутировал
        ArrayList<Integer> copy = new ArrayList<>(weights);
        Collections.sort(copy);
        int kayakCount = 0;

        while (!copy.isEmpty()) {
            int heaviest = copy.remove(copy.size() - 1);
            kayakCount++;

            if (!copy.isEmpty() && copy.get(0) + heaviest <= maxLoad) {
                copy.remove(0);
            }
        }
        return kayakCount;
    }
}
