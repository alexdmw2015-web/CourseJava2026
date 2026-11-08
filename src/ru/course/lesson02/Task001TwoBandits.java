package ru.course.lesson02;

// https://acmp.ru/index.asp?main=task&id_task=33

public class Task001TwoBandits {
    public static void main(String[] args) {
        int firstBandit = Integer.parseInt(IO.readln("Введите число выстрелов первого бандита: "));
        int secondBandit = Integer.parseInt(IO.readln("Введите число выстрелов второго бандита: "));
        int sumShots = firstBandit + secondBandit - 1;
        int leftShotsFirstBandit = sumShots - firstBandit;
        int leftShotsSecondBandit = sumShots - secondBandit;
        IO.println(leftShotsFirstBandit + " " + leftShotsSecondBandit);
      }
}