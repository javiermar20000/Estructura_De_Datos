package tarea6_pilas;

public class Pila {
    private char[] datos;
    private int tope;

    public Pila(int capacidad) {
        datos = new char[capacidad];
        tope = -1;
    }

    public void push(char elemento) {
        if (tope < datos.length - 1) {
            tope++;
            datos[tope] = elemento;
        }
    }

    public char pop() {
        if (!estaVacia()) {
            char elemento = datos[tope];
            tope--;
            return elemento;
        }
        return '\0'; // Carácter nulo para indicar pila vacía
    }

    public boolean estaVacia() {
        return tope == -1;
    }
}
