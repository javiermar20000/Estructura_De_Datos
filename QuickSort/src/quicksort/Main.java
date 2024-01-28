package quicksort;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Arreglo original:");
        imprimirArreglo(numeros);
        
        int izquierda = 0;
        int derecha = numeros.length - 1;
        QuickSort.quickSort(numeros, izquierda, derecha);
        
        System.out.println("\nArreglo ordenado con QuickSort:");
        imprimirArreglo(numeros);
    }

    static void imprimirArreglo(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}