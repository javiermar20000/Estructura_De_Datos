/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraylist;

import java.util.ArrayList; // Importa la clase ArrayList de java.util

//Tarea ArrayList
//Crear un arraylist sencillo en el cual añadiremos distintos valores 
//aleatorios sin orden especifico, luego, crear variables que represente alguna posición,
//seteamos la posicion 1 con nuevo valor (reemplaza a la posicion 1 original) y luego removemos la posicion 4, 
//y finalmente recorremos con un ciclo for todas las posiciones del arraylist que nos demostrará que la
//posicion 1 fue cambiada por el set y que, ademas se eliminó la posicion 4


public class ArrayListClass {

    public static void main(String[] args) {
        // Construimos un ArrayList de enteros
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(105);
        numeros.add(2000);
        numeros.add(342);
        numeros.add(22);
        numeros.add(12);

        // Generar los números por índice
        int primero = numeros.get(0);
        int segundo = numeros.get(1);
        int tercero = numeros.get(2);

        System.out.println("El primer número del ArrayList es: " + primero);
        System.out.println("El segundo número del ArrayList es: " + segundo);

        numeros.set(1, 3234567);
        numeros.remove(4);

        for (int i = 0; i < numeros.size(); i++) {
            System.out.println(numeros.get(i));
        }
    }
}