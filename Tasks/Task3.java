package Ex1;

import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {
        int[] numbers = {18, 12, 25, 85};
        int[][] digits = {
                {1, 8},
                {2, 5}
        };

        for (int i = 0; i < numbers.length - 1; i++) {
            if (!containsInAnyRow(digits, numbers[i]) || !containsInAnyColumn(digits, numbers[i + 1])) {
                System.out.println("Условие не выполнено для пары индексов: " +
                        "(" + i + "," + (i + 1) + "), " +
                        numbers[i] + "," + numbers[i + 1]);
            }
        }

    }

    private static boolean containsInAnyRow(int[][] digits, int number) {
        int[] numberDigits = getNumberDigits(number);
        for (int[] digit : digits) {
            if (containsSubarray(digit, numberDigits)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsInAnyColumn(int[][] digits, int number) {
        int[][] digitsTranspose = transpose(digits);
        int[] numberDigits = getNumberDigits(number);
        for (int[] ints : digitsTranspose) {
            if (containsSubarray(ints, numberDigits)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsSubarray(int[] base, int[] find) {
        var max = base.length - find.length;
        for (int i = 0; i <= max; i++) {
            boolean yes = true;
            for (int j = 0; j < find.length; j++) {
                if (base[i + j] != find[j]) {
                    yes = false;
                    break;
                }
            }
            if (yes) {
                return true;
            }
        }
        return false;
    }

    private static int[] getNumberDigits(int number) {
        int[] digits = new int[(int) Math.log10(number) + 1];
        for (int i = digits.length - 1; i >= 0 && number > 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    private static int[][] transpose(int[][] a) {
        int[][] aT = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a[i].length; j++) {
                int temp = a[i][j];
                aT[i][j] = a[j][i];
                aT[j][i] = temp;
            }
        }
        return aT;
    }
}

