package com.mycompany.tarea10xlsx_search;


public class NumberProcessor {
    public static void bubbleSort(double[] numbers) {
        int n = numbers.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (numbers[i - 1] > numbers[i]) {
                    // Intercambia numbers[i-1] y numbers[i]
                    double temp = numbers[i - 1];
                    numbers[i - 1] = numbers[i];
                    numbers[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public static int sequentialSearch(double[] numbers, double target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(double[] numbers, double target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void printFirstNElements(double[] numbers, int n) {
        if (n <= numbers.length) {
            System.out.print("Primeros " + n + " elementos ordenados: ");
            for (int i = 0; i < n; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("La cantidad especificada excede el tamaño del arreglo.");
        }
    }
}