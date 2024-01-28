package mergesort;

//Cambios y correcciones realizados:

//Se agregó el método merge para fusionar dos subarreglos.
//Se corrigió la llamada al método mergesort en el método main.
//Se añadieron comentarios para mejorar la comprensión del código.
//Se utilizó System.arraycopy para dividir el arreglo en lugar de una asignación directa.

public class MergeSort {
    public static void main(String[] args) {
        int[] arreglo = {25, 12, 15, 14, 13};
        System.out.println("Arreglo original:");
        printArray(arreglo);
        mergesort(arreglo);
        System.out.println("El arreglo ordenado:");
        printArray(arreglo);
    }
    
    public static void mergesort(int[] arreglo) {
        int n = arreglo.length;
        if (n > 1) {
            int mitad = n / 2; 
            int[] izquierda = new int[mitad];
            int[] derecha = new int[n - mitad];
            
            System.arraycopy(arreglo, 0, izquierda, 0, mitad);
            System.arraycopy(arreglo, mitad, derecha, 0, n - mitad);
            
            mergesort(izquierda);
            mergesort(derecha);
            
            merge(arreglo, izquierda, derecha);
        }
    }
    
    public static void merge(int[] arreglo, int[] izquierda, int[] derecha) {
        int n1 = izquierda.length;
        int n2 = derecha.length;
        int i = 0, j = 0, k = 0;
        
        while (i < n1 && j < n2) {
            if (izquierda[i] <= derecha[j]) {
                arreglo[k] = izquierda[i];
                i++;
            } else {
                arreglo[k] = derecha[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arreglo[k] = izquierda[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arreglo[k] = derecha[j];
            j++;
            k++;
        }
    }
    
    public static void printArray(int[] arreglo) {
        for (int valor : arreglo) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}