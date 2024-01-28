package binarysearch;

public class BinarySearch {
    public static int binarySearch(int numeros[], int valor) {
        int N = numeros.length;
        insertionSortUp(numeros);
        
        int i = 0;
        int j = N - 1;
        
        while (i <= j) {
            int m = (i + j) / 2;
            if (valor < numeros[m]) {
                j = m - 1;
            } else if (valor > numeros[m]) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    private static void insertionSortUp(int numeros[]) {
        int N = numeros.length;
        for (int i = 1; i < N; i++) {
            int n = numeros[i];
            int j = i - 1;
            while (j >= 0 && numeros[j] > n) {
                numeros[j + 1] = numeros[j];
                j--;
            }
            numeros[j + 1] = n;
        }
    }
}