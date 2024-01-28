package pilaarreglo;

//errores encontrados en el codigo proporcionado:
//No hay un constructor sin argumentos, El método desapilar() no maneja el caso de UNDERFLOW correctamente,
//el método tope() no maneja el caso de pila vacía y Uso de arreglos de tipo Object
//Este es el codigo corregido

public class PilaArreglo<T> {
  private T[] arreglo;
  private int tope;
  private int MAX_ELEM;

  public PilaArreglo(int maxElem) {
    MAX_ELEM = maxElem;
    arreglo = (T[]) new Object[MAX_ELEM];
    tope = -1;
  }

  public void apilar(T x) {
    if (tope + 1 < MAX_ELEM) {
      tope++;
      arreglo[tope] = x;
    } else {
      throw new IllegalStateException("Pila llena, no se puede apilar.");
    }
  }

  public T desapilar() {
    if (!estaVacia()) {
      T x = arreglo[tope];
      tope--;
      return x;
    } else {
      throw new IllegalStateException("La pila está vacía, no se puede desapilar.");
    }
  }

  public T tope() {
    if (!estaVacia()) {
      return arreglo[tope];
    } else {
      throw new IllegalStateException("La pila está vacía, no hay elemento en el tope.");
    }
  }

  public boolean estaVacia() {
    return tope == -1;
  }
}