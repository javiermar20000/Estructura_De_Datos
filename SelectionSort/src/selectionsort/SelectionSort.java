package selectionsort;

public class SelectionSort {
    public static void selectionSortUp(int numeros[]) {
        int N = numeros.length;
        int i, j, k, r = 0;
        int n, inter;
        
        for (i = 0; i < N - 1; i++) {
            inter = 0;
            k = i;
            n = numeros[i];
            
            for (j = i + 1; j < N; j++) {
                if (numeros[j] < n) {
                    r = j;
                    n = numeros[j];
                    inter = 1;
                }
            }
            
            if (inter == 1) {
                numeros[r] = numeros[i];
                numeros[i] = n;
            }
        }
    }
}

