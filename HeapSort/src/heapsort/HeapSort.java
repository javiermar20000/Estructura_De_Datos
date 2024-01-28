package heapsort;

//Cambios y correcciones realizados:

//Se corrigió la declaración de public static void heapsort(int[] arreglo) (se cambió statric a static).
//Se corrigieron los bucles for en los métodos heapsort y heapify para que usen la condición adecuada (se cambió i==0 a i >= 0 y i++ a i--).
//Se cambió 2*1 a 2*i en el cálculo de la posición de la derecha en el método heapify.
//Se cambió el método PublicArray a printArray y se corrigió su implementación para imprimir los valores del arreglo correctamente.
//Se agregaron comentarios para mejorar la comprensión del código.

public class HeapSort {
    public static void main(String[] args) {
        int[] arreglo = {25, 12, 15, 14, 13};
        System.out.println("Arreglo original:");
        printArray(arreglo);
        heapsort(arreglo);
        System.out.println("El arreglo ordenado:");
        printArray(arreglo);
    }
    
    public static void heapsort(int[] arreglo) {
        int n = arreglo.length;
        
        // Construir el max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arreglo, n, i);
        }
        
        // Extraer elementos uno por uno del heap
        for (int i = n - 1; i > 0; i--) {
            int temp = arreglo[0];
            arreglo[0] = arreglo[i];
            arreglo[i] = temp;
            heapify(arreglo, i, 0);
        }
    }
    
    public static void heapify(int[] arreglo, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && arreglo[left] > arreglo[largest]) {
            largest = left;
        }
        
        if (right < n && arreglo[right] > arreglo[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            int swap = arreglo[i];
            arreglo[i] = arreglo[largest];
            arreglo[largest] = swap;
            heapify(arreglo, n, largest);
        }
    }
    
    public static void printArray(int[] arreglo) {
        for (int valor : arreglo) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}