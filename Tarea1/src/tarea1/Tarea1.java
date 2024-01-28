package tarea1;
import java.util.Scanner;

//Tarea N°1: crear programa que contenga lo siguiente
//asignación, expresión, ciclo for, condicional y mostrar resultado por pantalla
public class Tarea1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Asignación: Solicitamos al usuario ingresar un número "n"
        System.out.print("Ingrese un número natural: ");
        int n = scanner.nextInt();
        

        // Expresión: Calculamos la suma de los primeros "n" números naturales
        int suma = 0;
        
        //Utilizamos ciclo for para calcular la suma de los numeros naturales desde 1 hasta "n"
        for (int i = 1; i <= n; i++) {
            suma += i;
        }

        // Condicional: Mostramos el resultado por pantalla solo si "n" es mayor que 0 y distinto de 1
        if (n > 1) {
            System.out.println("La suma de los primeros " + n + " números naturales es: " + suma);
            
        } else if(n == 1) {
            System.out.println("Para calcular la suma debe ingresar un valor natural mayor que 1");
        } else {
            System.out.println("El número ingresado debe ser mayor que 0 para calcular la suma.");
        }
        
    }
    
}
