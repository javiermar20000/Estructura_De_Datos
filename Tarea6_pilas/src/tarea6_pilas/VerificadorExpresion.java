package tarea6_pilas;

public class VerificadorExpresion {
    public static boolean verificarExpresion(String expresion) {
        Pila pila = new Pila(expresion.length());
        
        for (int i = 0; i < expresion.length(); i++) {
            char simbolo = expresion.charAt(i);

            if (simbolo == '(') {
                pila.push(simbolo);
            } else if (simbolo == ')') {
                if (pila.estaVacia()) {
                    return false;
                }
                pila.pop();
            }
        }

        return pila.estaVacia();
    }
}
