/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shellsort;

public class ShellSort {
    // Implementar el algoritmo Shell Sort
    static void shellSort(int[] array) {
        int n = array.length;

        // Inicializar la brecha inicial
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;

                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                array[j] = temp;
            }

            gap /= 2; // Reducir la brecha
        }
    }

    // Implementar el algoritmo de Bubble Sort
    static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambiar elementos si están en el orden incorrecto
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // Si no hubo intercambios en esta pasada, el arreglo ya está ordenado
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {25, 54, 22, 13, 11, 30, 32};
        int[] copyArray = array.clone(); // Copiamos el arreglo original para comparar con Bubble Sort

        // Medir el tiempo de ejecución de Shell Sort
        long startTime = System.nanoTime();
        shellSort(array);
        long endTime = System.nanoTime();
        long shellSortTime = endTime - startTime;

        System.out.println("Arreglo ordenado usando Shell Sort:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("\nTiempo de ejecución de Shell Sort: " + shellSortTime + " nanosegundos");

        // Reestablecer el arreglo original
        array = copyArray.clone();

        // Medir el tiempo de ejecución de Bubble Sort
        startTime = System.nanoTime();
        bubbleSort(array);
        endTime = System.nanoTime();
        long bubbleSortTime = endTime - startTime;

        System.out.println("\nArreglo ordenado usando Bubble Sort:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("\nTiempo de ejecución de Bubble Sort: " + bubbleSortTime + " nanosegundos");
    }
}