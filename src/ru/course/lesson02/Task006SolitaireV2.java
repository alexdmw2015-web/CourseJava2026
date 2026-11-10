public class Task006SolitaireV2 {
    static void main() {
        //Пользователь вводит small  и big
        int small = Integer.parseInt(IO.readln("введите кол-во карт в тоненькой колоде: "));
        int big = Integer.parseInt(IO.readln("введите кол-во карт в последней колоде: "));

        //Вычислить количество действий count
        int count = countSteps(small, big);
        //Вывести count
        IO.println(count);
    }

    private static int countSteps(int small, int big) {
        int counter = 0;
        int amountDesks = big - small + 1;
        System.out.println("amountDesks = " + amountDesks);
        for (int desk = small; desk <= big; desk++) {
            int x = desk;
            //Проделать хитрые манипуляции по условию пасьянса, изменяя при это счетчик
            counter += countManipulationsWithDesk(x);
        }

        return counter;
    }

    static int countManipulationsWithDesk(int size) {
        System.out.println("size = " + size);
        int counter = 0;
        while (size != 2) {
            if (size % 2 == 0) {
                size /= 2;
            } else {
                size = size * 3 + 1;
            }
            counter++;
            System.out.println(counter + ")    size = " + size);
        }
        System.out.println("counter = " + counter);
        return counter;
    }
}