package ru.course.lesson02;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringTokenizer;

public class HairBusinessBinaryMask {
    public static void main(String[] args) throws IOException {
        Path inPath  = Path.of("src/ru/course/lesson02/INPUT.txt");
        Path outPath = Path.of("src/ru/course/lesson02/OUTPUT.txt");

        int n;
        int[] c;
        try (BufferedReader br = Files.newBufferedReader(inPath, StandardCharsets.UTF_8)) {
            n = Integer.parseInt(br.readLine().trim());
            c = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }
        }

        long bestMoney = -1;
        int bestMask = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            if ((mask & (1 << (n - 1))) == 0) continue;

            long money = 0;
            long length = 1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    money += length * c[i];
                    length = 0;
                }
                length++;
            }
            if (money > bestMoney) {
                bestMoney = money;
                bestMask = mask;
            }
        }

        String bits = Integer.toBinaryString(bestMask);
        String reversed = new StringBuilder(bits).reverse().toString();
        System.out.println("Маска (bit i = день i): " + reversed);

        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(outPath, StandardCharsets.UTF_8))) {
            pw.println(reversed);
        }

        System.out.println("Максимальная сумма: " + bestMoney);
        System.out.println("Маска (bit i = день i): " + reversed);
    }
}