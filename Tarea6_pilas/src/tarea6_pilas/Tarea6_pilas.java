package tarea6_pilas;
import java.util.Scanner;

//Tarea N°6: Implementar funcionalidad de una pila en Java usando POO
//con varias clases y verificar si una expresión tiene coincidencias de paréntesis
//permitir al usuario ingresar la expresión a verificar.

public class Tarea6_pilas {
    public static void main(String[] args) {
        //String expresion = "(())()((()))"; | en el caso de dar una expresión predeterminada.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una expresión con paréntesis para ver si existen coincidencias: ");
        
        String expresion = scanner.nextLine();
        
        boolean resultado = VerificadorExpresion.verificarExpresion(expresion);

        if (resultado) {
            System.out.println("La expresión tiene coincidencias de paréntesis.");
        } else {
            System.out.println("La expresión NO tiene coincidencias de paréntesis.");
        }
    }
}
