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
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void insertionSort(int[] array) {
        for (int i = 2; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
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
        printArray(array);
        //bubbleSort(array);
        insertionSort(array);
        printArray(array);

        int min = getMin(array);
        System.out.println("Минимальное число в массиве: " + min);

        int max = getMax(array);
        System.out.println("Максимальное число в массиве: " + max);

        double mean = getMean(array);
        System.out.println("Среднее в массиве: " + mean);
    }
}