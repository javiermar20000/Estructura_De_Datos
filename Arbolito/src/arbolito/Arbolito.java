package arbolito;

//En java usando POO, Cree una clase que se llame nodo, dentro de la clase 
//crear una variable del tipo entero "int llamado elemento"
//también crear otras estructuras de datos
//que sellame nodo izquierdo y otra nodo derecho
//dentro del la clase nodo generar un constructor, 
//dentro del constructor nodo crear this.elemento = 
//el argumento es int elemento
//este constructor recibe int elementos y demntro del constructor elemento = elñemento
//this.izquierdo = null y this.derecho = null, y en otro codigo con una nueva clase BinaryTree crear otro objeto nodo, que va a ser la raiz
//esa clase que acabamos de crear va a tener un cnstructor que se va a llamar
//public nodo binario 10 y va a recibir un parametro como elemento
//adentro class 1 y 0, y dentro crear variable nodo raiz
//crear public arbolito 10, y dentro crear una variable raiz = null
//cerrar la clase y crear un metodo llamado insertar para insertar un valor al arbol
//vamos a crear un public void se va a llamar insertar y va a recibir el elemenmto entero declarado arriba
//Despues de crear las clases Arbolito, binaryTree y nodo se debe imprimir por pantalla
//los datos en forma ascendente y de forma descendente (ordenados)

public class Arbolito {
    public static void main(String[] args) {
        BinaryTree arbol = new BinaryTree(10);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(12);
        arbol.insertar(18);

        // Imprimir los elementos en orden ascendente
        System.out.print("Elementos en orden ascendente: ");
        arbol.imprimirEnOrdenAscendente();

        // Imprimir los elementos en orden descendente
        System.out.print("Elementos en orden descendente: ");
        arbol.imprimirEnOrdenDescendente();
    }
}