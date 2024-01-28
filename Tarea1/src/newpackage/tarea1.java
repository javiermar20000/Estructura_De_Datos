package newpackage;
import java.util.Scanner;

public class tarea1 {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese un número
        System.out.print("Ingrese un número entero: ");
        int numeroIngresado = scanner.nextInt();

        // Declaración e inicialización de variables
        int sumaPares = 0;

        // Ciclo for para sumar los números pares desde 1 hasta el número ingresado
        for (int i = 1; i <= numeroIngresado; i++) {
            if (i % 2 == 0) {
                sumaPares += i;
            }
        }

        // Mostrar el resultado por pantalla
        System.out.println("La suma de los números pares desde 1 hasta " + numeroIngresado + " es: " + sumaPares);

        // Cerrar el objeto Scanner
        scanner.close();
    }
}
