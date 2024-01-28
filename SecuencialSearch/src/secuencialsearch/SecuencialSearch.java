package secuencialsearch;

public class SecuencialSearch {
    public static int secuencialSearch(int numeros[], int valor) {
        int N = numeros.length;
        for (int i = 0; i < N; i++) {
            if (numeros[i] == valor) {
                return i;
            }
        }
        return -1;
    }
}