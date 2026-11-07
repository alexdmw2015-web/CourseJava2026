package ru.course.lesson02;

// https://acmp.ru/index.asp?main=task&id_task=294

public class Task002boltsAndNuts {
    public static void main(String[] args) {

        int k1 = 1000, l1 = 10, m1 = 100;
        int k2 = 1200, l2 = 20, m2 = 90;
        int lostBolts = k1 * l1 / 100;
        int leftBolts = k1 - lostBolts;
        int lostNuts = k2 * l2 / 100;
        int leftNuts = k2 - lostNuts;

        int lossFromLost = lostBolts * m1 + lostNuts * m2;   // ущерб от потерь

        int unpaired;                                         // ущерб от непарных
        if (leftBolts > leftNuts) {
            unpaired = (leftBolts - leftNuts) * m1;
        } else {
            unpaired = (leftNuts - leftBolts) * m2;
        }

        System.out.println(lossFromLost + unpaired);
    }
}
