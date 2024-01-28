package tarea5_pilas;

import java.util.Stack;

public class PilaInversa {
    private Stack<Integer> pila;

    public PilaInversa() {
        pila = new Stack<>();
    }

    public void agregarElemento(int elemento) {
        pila.push(elemento);
    }

    public void mostrarEnOrdenInverso() {
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }
}