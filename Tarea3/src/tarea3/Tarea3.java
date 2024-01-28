package tarea3;

//Tarea N°3: usando Tipo de Dato Abstracto (TDA) y programación orientada a objetos (POO)
//realizar la suma, resta, multuplicación y división de datos que representen una fracción

public class Tarea3 {


    public static void main(String[] args) {
        cociente uno = new cociente(3, 4);
        cociente dos = new cociente(7, 3);
        System.out.println("La primera fracción es: "+uno);
        System.out.println("La segunda fracción es: "+dos);
        System.out.println("-------------------------------------------------------");
        System.out.println("La multiplicación de "+uno+" y "+dos+" es igual a: "+uno.multiplicar(dos));
        System.out.println("-------------------------------------------------------");
        System.out.println("La suma de "+uno+" y "+dos+" es igual a: "+uno.suma(dos));
        System.out.println("-------------------------------------------------------");
        System.out.println("La resta de "+uno+" y "+dos+" es igual a: "+uno.resta(dos));
        System.out.println("-------------------------------------------------------");
        System.out.println("La división de "+uno+" y "+dos+" es igual a: "+uno.dividir(dos));
        System.out.println("\n-------------FINAL DEL PROGRAMA---------------------------");
        
        
    }
    
}
