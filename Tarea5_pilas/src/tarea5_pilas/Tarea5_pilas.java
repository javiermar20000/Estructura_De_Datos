package tarea5_pilas;

import java.util.Scanner;

//Tarea N°5 Estructura de Datos
//crear un programa en java usando POO con varias clases en distintos codigos 
//que lea una secuencia de elementos enteros, luego que se muestre por pantalla
//en orden inverso los elementos ingresados usando pilas.

public class Tarea5_pilas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilaInversa pilaInversa = new PilaInversa();

        System.out.print("Ingrese la cantidad de elementos: ");
        int cantidad = scanner.nextInt();

        System.out.println("Ingrese los elementos:");

        for (int i = 0; i < cantidad; i++) {
            int elemento = scanner.nextInt();
            pilaInversa.agregarElemento(elemento);
        }

        System.out.println("Elementos en orden inverso:");

        pilaInversa.mostrarEnOrdenInverso();
    }
}