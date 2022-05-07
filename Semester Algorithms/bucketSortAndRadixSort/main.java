package bucketSortAndRadixSort;

import java.util.Random;

import static bucketSortAndRadixSort.radixSort.radixSorted;

public class main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] intArr = new int[(int) 1e7];
        int n = intArr.length;
        for (int i = 0; i < n; i++) {
            intArr[i] = random.nextInt(100);
        }
//        System.out.println("Исходный массив: " + Arrays.toString(intArr));
        long start = System.nanoTime();
//        bucketSorted(intArr, 100);
            radixSorted(intArr,n);
        long finish = System.nanoTime();
        long difference = finish - start;
//        System.out.println("Отсортированный массив: " + Arrays.toString(intArr));
        System.out.println("Кол-во элементов: " + n + "\n"
                + "Затраченное время: " + difference/1000 + " м/с"
        );
    }
}

