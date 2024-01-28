package bubblesort;

public class BubbleSort {
    public static void bubbleSort(int numeros[]) {
        int N = numeros.length;
        int i, j;
        for (i = 0; i < N - 1; i++) {
            for (j = 0; j < N - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int aux = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = aux;
                }
            }
        }
    }
}