package bucketSortAndRadixSort;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class bucketSort {
    static void bucketSorted(int[] intArr, int noOfBuckets) {
        // Создать массив buckets
        List<Integer>[] buckets = new List[noOfBuckets];
        // Связать список с каждым индексом
        // в массиве buckets
        for (int i = 0; i < noOfBuckets; i++) {
            buckets[i] = new LinkedList<>();
        }
        // Назначить числа из массива в соответствующую ячейку
        // с помощью функции hash()
        for (int num : intArr) {
            buckets[hash(num)].add(num);
        }
        // отсортировать buckets
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int i = 0;
        // Объединить сегменты, чтобы получить отсортированный массив
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                intArr[i++] = num;
            }
        }
    }
    private static int hash(int num){
        return num/10;
    }
}

