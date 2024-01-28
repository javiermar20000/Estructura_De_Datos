package tareapresena;

import java.util.Arrays;
import java.util.Random;

public class TareaPreSena {
    public static void main(String[] args) {
        int[] data = generateRandomArray(100000);

        // Crear una instancia de SortingAlgorithms
        SortingAlgorithms algorithms = new SortingAlgorithms();

        // Medir el tiempo de ejecución para Bubble Sort
        int[] bubbleSortCopy = Arrays.copyOf(data, data.length);
        long bubbleSortTime = measureTime(() -> algorithms.bubbleSort(bubbleSortCopy));

        // Medir el tiempo de ejecución para Insertion Sort
        int[] insertionSortCopy = Arrays.copyOf(data, data.length);
        long insertionSortTime = measureTime(() -> algorithms.insertionSort(insertionSortCopy));

        // Medir el tiempo de ejecución para Selection Sort
        int[] selectionSortCopy = Arrays.copyOf(data, data.length);
        long selectionSortTime = measureTime(() -> algorithms.selectionSort(selectionSortCopy));

        // Medir el tiempo de ejecución para Merge Sort
        int[] mergeSortCopy = Arrays.copyOf(data, data.length);
        long mergeSortTime = measureTime(() -> algorithms.mergeSort(mergeSortCopy));

        // Medir el tiempo de ejecución para Quick Sort
        int[] quickSortCopy = Arrays.copyOf(data, data.length);
        long quickSortTime = measureTime(() -> algorithms.quickSort(quickSortCopy));

        // Medir el tiempo de ejecución para Shell Sort
        int[] shellSortCopy = Arrays.copyOf(data, data.length);
        long shellSortTime = measureTime(() -> algorithms.shellSort(shellSortCopy));
        

        // Imprime los tiempos de ejecución para algoritmos de comportamiento cuadrático
        System.out.println("Algoritmos de comportamiento cuadratico: ");
        System.out.println("Bubble Sort demoro " + nanosecondsToSeconds(bubbleSortTime) + " segundos.");
        System.out.println("Insertion Sort demoro " + nanosecondsToSeconds(insertionSortTime) + " segundos.");
        System.out.println("Selection Sort demoro " + nanosecondsToSeconds(selectionSortTime) + " segundos.");
        System.out.println("-----------------------------------------------------------");

        // Imprime los tiempos de ejecución para algoritmos de ordenamiento
        System.out.println("Algoritmos de ordenamiento: ");
        System.out.println("Merge Sort demoro " + nanosecondsToSeconds(mergeSortTime) + " segundos.");
        System.out.println("Quick Sort demoro " + nanosecondsToSeconds(quickSortTime) + " segundos.");
        System.out.println("Shell Sort demoro " + nanosecondsToSeconds(shellSortTime) + " segundos.");

        // Determinar el algoritmo más eficiente en comportamiento cuadrático
        String algoritmoCuadraticoEficiente;
        long tiempoCuadraticoEficiente;

        if (bubbleSortTime < insertionSortTime && bubbleSortTime < selectionSortTime) {
            algoritmoCuadraticoEficiente = "Bubble Sort";
            tiempoCuadraticoEficiente = bubbleSortTime;
        } else if (insertionSortTime < selectionSortTime) {
            algoritmoCuadraticoEficiente = "Insertion Sort";
            tiempoCuadraticoEficiente = insertionSortTime;
        } else {
            algoritmoCuadraticoEficiente = "Selection Sort";
            tiempoCuadraticoEficiente = selectionSortTime;
        }
        System.out.println("-------------------------------------------------------------");

        System.out.println("El algoritmo de comportamiento cuadratico más eficiente es " + algoritmoCuadraticoEficiente + " con " + nanosecondsToSeconds(tiempoCuadraticoEficiente) + " segundos.");

        // Determinar el algoritmo más eficiente en ordenamiento
        String algoritmoOrdenamientoEficiente;
        long tiempoOrdenamientoEficiente;

        if (mergeSortTime < quickSortTime && mergeSortTime < shellSortTime) {
            algoritmoOrdenamientoEficiente = "Merge Sort";
            tiempoOrdenamientoEficiente = mergeSortTime;
        } else if (quickSortTime < shellSortTime) {
            algoritmoOrdenamientoEficiente = "Quick Sort";
            tiempoOrdenamientoEficiente = quickSortTime;
        } else {
            algoritmoOrdenamientoEficiente = "Shell Sort";
            tiempoOrdenamientoEficiente = shellSortTime;
        }

        System.out.println("El algoritmo de ordenamiento más eficiente es " + algoritmoOrdenamientoEficiente + " con " + nanosecondsToSeconds(tiempoOrdenamientoEficiente) + " segundos.");
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000); // Se puede variar el rango de datos aleatorios
        }
        return arr;
    }

    public static long measureTime(Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    public static double nanosecondsToSeconds(long nanoseconds) {
    return nanoseconds / 1e9;
}
}