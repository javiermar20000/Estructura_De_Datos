package com.mycompany.tarea10xlsx_search;

//Crear un programa en java usando POO con varias clases distribuidas en distintos
//codigos, este codigo debera ser capaz de leer un archivo .xlsx y guardar los
//numeros que contenga dentro de un arreglo, y que ordene esos numeros, luego,
//vamos a buscar un elemento utilizando una busqueda secuencial y una busqueda
//binaria, cada de una de estas busquedas debera añadir un start time, es decir,
//que muestre el tiempo de ejecucion de la busqueda secuencial y binaria.

import java.util.List;

public class Tarea10XLSX_Search {
    public static void main(String[] args) {

        try {
            String filePath = "DatosParaArreglo.xlsx";
            List<Double> numbersList = ExcelReader.readNumbersFromExcel(filePath);
            double[] numbers = new double[numbersList.size()];

            // Convertir la lista de números en un arreglo
            for (int i = 0; i < numbersList.size(); i++) {
                numbers[i] = numbersList.get(i);
            }

            // Medir el tiempo de ejecución para ordenar los números con el método de burbuja
            long startTime = System.nanoTime();
            NumberProcessor.bubbleSort(numbers);
            long endTime = System.nanoTime();
            long sortTime = endTime - startTime;
            System.out.println("Tiempo de ordenación (Bubble Sort): " + sortTime + " nanosegundos");

            // Realizar búsqueda secuencial
            double target = 318518.0;
            startTime = System.nanoTime();
            int sequentialResult = NumberProcessor.sequentialSearch(numbers, target);
            endTime = System.nanoTime();
            long sequentialSearchTime = endTime - startTime;

            System.out.println("-------------------------------------------------------------------------------------------");
            NumberProcessor.printFirstNElements(numbers, 10);
            System.out.println("-------------------------------------------------------------------------------------------");

            if (sequentialResult != -1) {
                System.out.println("Búsqueda secuencial: El número " + target + " se encuentra en la posición " + sequentialResult);
                System.out.println("Tiempo de búsqueda secuencial: " + sequentialSearchTime + " nanosegundos");
            } else {
                System.out.println("Búsqueda secuencial: El número " + target + " no se encontró en el arreglo.");
                System.out.println("Tiempo de búsqueda secuencial: " + sequentialSearchTime + " nanosegundos");
            }

            // Realizar búsqueda binaria
            startTime = System.nanoTime();
            int binaryResult = NumberProcessor.binarySearch(numbers, target);
            endTime = System.nanoTime();
            long binarySearchTime = endTime - startTime;

            if (binaryResult != -1) {
                System.out.println("Búsqueda binaria: El número " + target + " se encuentra en la posición " + binaryResult);
                System.out.println("Tiempo de búsqueda binaria: " + binarySearchTime + " nanosegundos");
            } else {
                System.out.println("Búsqueda binaria: El número " + target + " no se encontró en el arreglo.");
                System.out.println("Tiempo de búsqueda binaria: " + binarySearchTime + " nanosegundos");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Después de ordenar los números, imprime los primeros 10 elementos
    }
}