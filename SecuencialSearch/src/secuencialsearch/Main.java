package secuencialsearch;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {64, 34, 25, 12, 22, 11, 90};
        int valorBuscado = 22;

        System.out.println("Arreglo original:");
        imprimirArreglo(numeros);

        int indiceEncontrado = SecuencialSearch.secuencialSearch(numeros, valorBuscado);

        if (indiceEncontrado != -1) {
            System.out.println("\nEl valor " + valorBuscado + " se encuentra en el índice " + indiceEncontrado);
        } else {
            System.out.println("\nEl valor " + valorBuscado + " no se encuentra en el arreglo.");
        }
    }

    static void imprimirArreglo(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}