package ru.course.lesson02;

import java.util.Scanner;

public class Task005Conditioner {
    public static void main(String[] args) {
        // Инициализация сканера и исходных данных
        Scanner sc = new Scanner(System.in);

        // Ввод данных от пользователя

        System.out.print("Введите текущую и желаемую температуру в комнате через пробел от -50 до +50: ");
        int tRoom = sc.nextInt();
        int tCond = sc.nextInt();


        System.out.print("Выберите режим работы (freeze, heat, auto, fan): ");
        String mode = sc.next();
        int finalTemp = tRoom; // температура по умолчанию
// Обработка результатов
        switch (mode) {
            case "freeze":
                if (tCond >= tRoom) {
                    finalTemp = tRoom;
                } else {
                    finalTemp = tCond;
                }
                break;
            case "heat":
                if (tCond >= tRoom) {
                    finalTemp = tCond;
                } else {
                    finalTemp = tRoom;
                }
                break;
            case "auto":
                finalTemp = tCond;
                break;
            case "fan":
                finalTemp = tRoom;
                break;
            default:
                System.out.println("Неизвестный режим: " + mode);
                finalTemp = tRoom;
        }

        // Вывод результатов

        System.out.println("Температура через час: " + finalTemp);

        sc.close();
    }
}
