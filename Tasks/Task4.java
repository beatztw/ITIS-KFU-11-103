package Ex1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task4 {

    private static final char[] CHARS_POOL = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'
    };
    private static final char[] VOWELS = {
            'a', 'e', 'i', 'o', 'u', 'y',
            'A', 'E', 'I', 'O', 'U', 'Y'
    };
    private static final Random rnd = new Random(2021);

    private static boolean isVowel(char ch) {
        for (char vowel : VOWELS) {
            if (ch == vowel) {
                return true;
            }
        }
        return false;
    }

    private static void fillArrayGeneratedData(String[] a, int leftLenBound, int rightLenBound) {
        for (int i = 0; i < a.length; i++) {
            a[i] = getRandomString(leftLenBound, rightLenBound);
        }
    }

    private static String getRandomString(int leftLenBound, int rightLenBound) {
        int sLength = rnd.nextInt( rightLenBound - leftLenBound + 1) + leftLenBound;
        String s = "";
        for (int i = 0; i < sLength; i++) {
            s += getRandomChar();
        }
        return s;
    }

    private static char getRandomChar() {
        return CHARS_POOL[rnd.nextInt(CHARS_POOL.length)];
    }

    private static int getVowelsCount(String s) {
        int vowelsCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                vowelsCount++;
            }
        }
        return vowelsCount;
    }

    private static String replacer(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (isVowel(ch)) {
                if (("" + ch).toLowerCase().equals("" + ch)) {
                    chars[i] = 'a';
                } else {
                    chars[i] = 'A';
                }
            }
        }
        String newString = "";
        for (char ch : chars) {
            newString += ch;
        }
        return newString;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] a = new String[n];
        fillArrayGeneratedData(a, 5, 10);
        System.out.println("a = " + Arrays.toString(a));

        int correctStringsCount = 0;
        for (String s : a) {
            if (getVowelsCount(s) <= 3) {
                correctStringsCount++;
            }
        }
        String[] correctStrings = new String[correctStringsCount];
        for (int i = 0, j = 0; i < a.length && j < correctStrings.length; i++) {
            if (getVowelsCount(a[i]) <= 3) {
                correctStrings[j++] = replacer(a[i]);
            }
        }

        System.out.println("correctStrings = " + Arrays.toString(correctStrings));
    }
}