package com.mycompany.tarea9xlsx;

//Crear un programa en java usando POO con varias clases distribuidas en distintos codigos,
//este codigo debera ser capaz de leer un archivo .xlsx y guardar los numeros que contenga
//dentro de un arreglo, luego se debera ordenar este arreglo utilizando el metodo de
//ordenamiento bubblesort, selectionsort y insertionSort, tambien se debera agregar
//el uso de start time para comparar los tiempos de ejecucion por cada
//metodo de ordenamiento utilizado.

import java.util.List;

public class Tarea9XLSX {
    public static void main(String[] args) {
        String filePath = "DatosParaArreglo.xlsx";

        List<Double> numbers = ExcelReader.readNumbersFromExcel(filePath);

        double[] arrBubbleSort = numbers.stream().mapToDouble(Double::doubleValue).toArray();
        double[] arrSelectionSort = numbers.stream().mapToDouble(Double::doubleValue).toArray();
        double[] arrInsertionSort = numbers.stream().mapToDouble(Double::doubleValue).toArray();

        Timer timer = new Timer();

        // Bubble Sort
        timer.start();
        SortAlgorithms.bubbleSort(arrBubbleSort);
        long bubbleSortTime = timer.stop();
        System.out.println("Bubble Sort Time: " + bubbleSortTime + " ms");
        printFirstNElements(arrBubbleSort, 10);

        // Selection Sort
        timer.start();
        SortAlgorithms.selectionSort(arrSelectionSort);
        long selectionSortTime = timer.stop();
        System.out.println("Selection Sort Time: " + selectionSortTime + " ms");
        printFirstNElements(arrSelectionSort, 10);

        // Insertion Sort
        timer.start();
        SortAlgorithms.insertionSort(arrInsertionSort);
        long insertionSortTime = timer.stop();
        System.out.println("Insertion Sort Time: " + insertionSortTime + " ms");
        printFirstNElements(arrInsertionSort, 10);
    }

    public static void printFirstNElements(double[] arr, int n) {
        if (n <= arr.length) {
            System.out.print("Primeros " + n + " elementos ordenados: ");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("La cantidad especificada excede el tamaño del arreglo.");
        }
    }
}