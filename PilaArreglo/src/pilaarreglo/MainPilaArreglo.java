package pilaarreglo;

//Clase Principal
public class MainPilaArreglo {
    public static void main(String[] args) {
        PilaArreglo<Integer> pila = new PilaArreglo<>(5); // Crear una pila con un tamaño máximo de 5 elementos

        System.out.println("¿La pila está vacía? " + pila.estaVacia()); // Debería imprimir true

        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);

        System.out.println("El tope de la pila es: " + pila.tope()); // Debería imprimir 3

        pila.desapilar();

        System.out.println("El tope de la pila después de desapilar es: " + pila.tope()); // Debería imprimir 2

        pila.apilar(4);
        pila.apilar(5);

        System.out.println("¿La pila está llena? " + (pila.estaVacia() ? "No" : "Sí")); // Debería imprimir Sí
    }
}

