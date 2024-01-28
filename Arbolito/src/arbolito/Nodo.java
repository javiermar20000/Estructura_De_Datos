package arbolito;

// Clase Nodo
class Nodo {
    int elemento; // agregamos el elemento entero
    Nodo izquierdo; //creamos los nodos izquierdo y derecho
    Nodo derecho;

    // Constructor de Nodo
    public Nodo(int elemento) { // creamos el constructor asociado
        this.elemento = elemento;
        this.izquierdo = null;
        this.derecho = null;
    }
}

// Clase BinaryTree donde se va a insertar y recibir el o los elementos
class BinaryTree {
    Nodo raiz;

    // Constructor de BinaryTree
    public BinaryTree(int elementoRaiz) {
        raiz = new Nodo(elementoRaiz);
    }

    // Método público para insertar un valor en el árbol
    public void insertar(int elemento) {
        raiz = insertarRecursivo(raiz, elemento);
    }

    // Método privado para insertar recursivamente un valor en el árbol
    private Nodo insertarRecursivo(Nodo nodo, int elemento) {
        if (nodo == null) {
            return new Nodo(elemento);
        }

        if (elemento < nodo.elemento) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, elemento);
        } else if (elemento > nodo.elemento) {
            nodo.derecho = insertarRecursivo(nodo.derecho, elemento);
        }

        return nodo;
    }

    // Método para imprimir los elementos en orden ascendente
    public void imprimirEnOrdenAscendente() { //imprime elementos del nodo raiz en forma ascendente
        imprimirEnOrdenAscendenteRecursivo(raiz);
        System.out.println();
    }

    // Método privado para imprimir en orden ascendente recursivamente
    private void imprimirEnOrdenAscendenteRecursivo(Nodo nodo) {
        if (nodo != null) {
            imprimirEnOrdenAscendenteRecursivo(nodo.izquierdo);
            System.out.print(nodo.elemento + " ");
            imprimirEnOrdenAscendenteRecursivo(nodo.derecho);
        }
    }

    // Método para imprimir los elementos en orden descendente
    public void imprimirEnOrdenDescendente() { //imprime elementos del nodo raiz en forma descendente
        imprimirEnOrdenDescendenteRecursivo(raiz);
        System.out.println();
    }

    // Método privado para imprimir en orden descendente recursivamente
    private void imprimirEnOrdenDescendenteRecursivo(Nodo nodo) {
        if (nodo != null) {
            imprimirEnOrdenDescendenteRecursivo(nodo.derecho);
            System.out.print(nodo.elemento + " ");
            imprimirEnOrdenDescendenteRecursivo(nodo.izquierdo);
        }
    }
}