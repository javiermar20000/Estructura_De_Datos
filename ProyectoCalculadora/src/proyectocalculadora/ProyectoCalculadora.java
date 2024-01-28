package proyectocalculadora;


public class ProyectoCalculadora {

    public static void main(String[] args) {
        //Todo lo relacionado a la parte logica del programa
        //el 10 pasa al operando 1 y el 2 pasa al operando 2
        
        Calculadora miCalculadora = new Calculadora(10,2);
        int suma = miCalculadora.sumar();
        System.out.println("La suma de sus operandos es: "+suma);
        System.out.println("La resta de sus operandos es: "+miCalculadora.restar());
        System.out.println("La multiplicacion de los operandos es: "+miCalculadora.multiplicar());
        System.out.println("La division de nuestros operandos es: "+miCalculadora.dividir());
    }
}
