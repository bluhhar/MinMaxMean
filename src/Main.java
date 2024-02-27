import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private final static int a = 41;
    private final static int c = 11119;
    private final static int m = 11113;
    private static int seed = 1;

    private static int getNextRandom() {
        seed = (a * seed + c) % m;
        return seed;
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = getNextRandom();
        }
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println("----------------");
    }

    private static void bubbleSort(int[] array) {
        int[] a = Arrays.copyOf(array, array.length);
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        //printArray(a);
    }

    private static void insertionSort(int[] array) {
        int[] a = Arrays.copyOf(array, array.length);
        for (int i = 2; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
        //printArray(a);
    }

    private static void shakerSort(int[] array) {
        int[] a = Arrays.copyOf(array, array.length);
        int left = 0;
        int right = a.length - 1;
        int temp;
        do {
            for (int i = left; i < right; i++) {
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (a[i] < a[i - 1]) {
                    temp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = temp;
                }
            }
            left++;
        } while(left < right);
        //printArray(a);
    }

    private static int getMin(int[] array) {
        int min = array[0];
        for (int i : array) {
            if(i < min) {
                min = i;
            }
        }
        return min;
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int i : array) {
            if(i > max) {
                max = i;
            }
        }
        return max;
    }

    private static double getMean(int[] array) {
        double sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum / array.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размерность массива: ");
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];
        fillArray(array);

        //printArray(array);

        long startTime = System.currentTimeMillis();
        bubbleSort(array);
        long endTime = System.currentTimeMillis();
        long timeBubbleSortElapsed = endTime - startTime;

        startTime = System.currentTimeMillis();
        insertionSort(array);
        endTime = System.currentTimeMillis();
        long timeInsertionSortElapsed = endTime - startTime;

        startTime = System.currentTimeMillis();
        shakerSort(array);
        endTime = System.currentTimeMillis();
        long timeShakerSortElapsed = endTime - startTime;

        int min = getMin(array);
        System.out.println("Минимальное число в массиве: " + min);

        int max = getMax(array);
        System.out.println("Максимальное число в массиве: " + max);

        double mean = getMean(array);
        System.out.println("Среднее в массиве: " + mean);

        System.out.println("Время сортировки пузырьком: " + timeBubbleSortElapsed + " мс.");
        System.out.println("Время сортировки вставками: " + timeInsertionSortElapsed + " мс.");
        System.out.println("Время сортировки вставками: " + timeShakerSortElapsed + " мс.");
    }
}