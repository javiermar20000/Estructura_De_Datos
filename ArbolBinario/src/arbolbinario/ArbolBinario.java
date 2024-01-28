package arbolbinario;

class Nodo {
    int num;
    Nodo izquierdo, derecho; // es un objeto abstracto
    
    public Nodo(int item) {
        num = item;
        izquierdo = derecho = null;
    }
}

public class ArbolBinario {
    Nodo raiz;
    
    // generar la construcción del árbol
    public ArbolBinario() {
        raiz = null;
    } 
    
    void insertar(int num) {
        // es una inserción de orden superior, recursiva, porque podemos insertar elementos en la raíz
        // tanto en la izquierda como la derecha
        raiz = recursiva_insertar(raiz, num);
    }
    
    // función recursiva para insertar
    Nodo recursiva_insertar(Nodo raiz, int num) {
        // si el árbol llegase a estar vacío, creamos un nodo
        if (raiz == null) {
            raiz = new Nodo(num);
            return raiz;
        }
        
        // recorrer el árbol que ya existe
        if (num < raiz.num) {
            raiz.izquierdo = recursiva_insertar(raiz.izquierdo, num);
        } else if (num > raiz.num) {
            raiz.derecho = recursiva_insertar(raiz.derecho, num);
        }
        return raiz;
    }
    
    Nodo buscar(int num) {
        return recursiva_busca(raiz, num);
    }
    
    Nodo recursiva_busca(Nodo raiz, int num) {
        if (raiz == null || raiz.num == num) {
            return raiz;
        }
        if (num < raiz.num) {
            return recursiva_busca(raiz.izquierdo, num);
        }
        return recursiva_busca(raiz.derecho, num);
    }

    public static void main(String[] args) {
        // generar en este main un árbol, es decir
        // crear un objeto
        ArbolBinario arbol = new ArbolBinario();
        
        int abuscar = 21;
        // insertar elementos al árbol
        arbol.insertar(25);
        arbol.insertar(252);
        arbol.insertar(252);
        arbol.insertar(2);
        arbol.insertar(2111111);
        arbol.insertar(21);
        arbol.insertar(12);
        arbol.insertar(1111111112);
        
        Nodo resultado_busqueda = arbol.buscar(abuscar);
        if (resultado_busqueda == null){
            System.out.println("El elemento buscado no está en el árbol");
        } else {
            System.out.println("El elemento " + abuscar + " buscado se encontró dentro del árbol");
        }
    }
}