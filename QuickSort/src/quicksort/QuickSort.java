package quicksort;

public class QuickSort {
    public static void quickSort(int[] numeros, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(numeros, izquierda, derecha);
            quickSort(numeros, izquierda, indiceParticion - 1);
            quickSort(numeros, indiceParticion + 1, derecha);
        }
    }

    private static int particion(int[] numeros, int izquierda, int derecha) {
        int pivote = numeros[derecha];
        int i = (izquierda - 1);

        for (int j = izquierda; j < derecha; j++) {
            if (numeros[j] <= pivote) {
                i++;
                int temp = numeros[i];
                numeros[i] = numeros[j];
                numeros[j] = temp;
            }
        }

        int temp = numeros[i + 1];
        numeros[i + 1] = numeros[derecha];
        numeros[derecha] = temp;

        return i + 1;
    }
}