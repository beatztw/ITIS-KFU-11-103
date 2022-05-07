package bucketSortAndRadixSort;

import java.util.Arrays;

public class radixSort {
    static int getMax(int arr[], int n)
    {
        int maxValue = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > maxValue)
                maxValue = arr[i];
        return maxValue;
    }

    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // выходной массив
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Сохранение количества вхождений в count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Измените count[i] так, чтобы count[i] теперь содержал фактическую позицию этой цифры в выводе[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Построить выходной массив
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Копирование выходного массива в arr[], чтобы arr[] теперь содержал отсортированные числа в соответствии с текущей цифрой
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // Основная функция для этой сортировки arr[] размера n с использованием RadixSort
    static void radixSorted(int arr[], int n)
    {
        // Найдите максимальное число, чтобы узнать количество цифр
        int m = getMax(arr, n);

        // Выполните подсчетную сортировку для каждой цифры. Обратите внимание,
        // что вместо передачи цифрового числа передается exp. exp равен 10 ^i, где i - текущее значное число
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}
