package ru.course.lesson02;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class HairBusinessBinaryMask {

    private static final Path IN_PATH  = Path.of("src/ru/course/lesson02/INPUT.txt");
    private static final Path OUT_PATH = Path.of("src/ru/course/lesson02/OUTPUT.md");

    /** Результат одной комбинации. */
    static class Combo {
        int mask;
        String bits;
        long sum;
        long[] daily;

        Combo(int mask, String bits, long sum, long[] daily) {
            this.mask = mask;
            this.bits = bits;
            this.sum = sum;
            this.daily = daily;
        }
    }

    /** Входные данные задачи. */
    static class Input {
        int n;
        int[] c;

        Input(int n, int[] c) {
            this.n = n;
            this.c = c;
        }
    }

    /** Результат расчёта: все комбинации + максимальная сумма. */
    static class Result {
        int n;
        List<Combo> combos;
        long bestMoney;

        Result(int n, List<Combo> combos, long bestMoney) {
            this.n = n;
            this.combos = combos;
            this.bestMoney = bestMoney;
        }
    }

    public static void main(String[] args) throws IOException {
        Input input   = readInput(IN_PATH);
        Result result = calculate(input);
        writeOutput(OUT_PATH, result);
        System.out.println("Результат записан в " + OUT_PATH);
        System.out.println("Максимальная сумма: " + result.bestMoney);
    }

    /** Чтение входных данных из txt-файла. */
    private static Input readInput(Path path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] c = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }
            return new Input(n, c);
        }
    }

    /** Перебор всех допустимых масок, подсчёт сумм и сортировка по убыванию. */
    private static Result calculate(Input input) {
        int n = input.n;
        int[] c = input.c;

        List<Combo> combos = new ArrayList<>();
        long bestMoney = -1;

        for (int mask = 0; mask < (1 << n); mask++) {
            if ((mask & (1 << (n - 1))) == 0) continue;

            long money = 0;
            long length = 1;
            long[] daily = new long[n];
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    long sale = length * c[i];
                    money += sale;
                    daily[i] = sale;
                    length = 0;
                }
                length++;
            }

            String bits = Integer.toBinaryString(mask);
            String reversed = new StringBuilder(bits).reverse().toString();
            combos.add(new Combo(mask, reversed, money, daily));

            if (money > bestMoney) {
                bestMoney = money;
            }
        }

        combos.sort(Comparator.comparingLong((Combo cb) -> cb.sum).reversed());
        return new Result(n, combos, bestMoney);
    }

    /** Вывод результата в Markdown-таблицу. */
    private static void writeOutput(Path path, Result result) throws IOException {
        int n = result.n;
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))) {
            pw.println("1 = продавать, 0 = держать");
            pw.println();
            writeTableHeader(pw, n);
            writeTableRows(pw, result);
        }
    }

    private static void writeTableHeader(PrintWriter pw, int n) {
        StringBuilder header = new StringBuilder("| # | Комбинация | Сумма |");
        StringBuilder sep    = new StringBuilder("|---|------------|-------|");
        for (int i = 0; i < n; i++) {
            header.append(" День ").append(i).append(" |");
            sep.append("------|");
        }
        pw.println(header);
        pw.println(sep);
    }

    private static void writeTableRows(PrintWriter pw, Result result) {
        int idx = 1;
        for (Combo cb : result.combos) {
            String sumCell = (cb.sum == result.bestMoney)
                    ? cb.sum + " ⭐"
                    : String.valueOf(cb.sum);

            StringBuilder row = new StringBuilder();
            row.append("| ").append(idx)
                    .append(" | `").append(cb.bits).append("`")
                    .append(" | ").append(sumCell).append(" |");
            for (long v : cb.daily) {
                row.append(" ").append(v).append(" |");
            }
            pw.println(row);
            idx++;
        }
    }
}