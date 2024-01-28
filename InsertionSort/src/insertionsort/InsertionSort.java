package insertionsort;

public class InsertionSort {
    public static void insertionSortUp(int numeros[]) {
        int N = numeros.length;
        int i, j, n;
        
        for (i = 1; i < N; i++) {
            n = numeros[i];
            for (j = i - 1; (j >= 0) && (n < numeros[j]); j--) {
                numeros[j + 1] = numeros[j];
            }
            numeros[j + 1] = n;
        }
    }
}