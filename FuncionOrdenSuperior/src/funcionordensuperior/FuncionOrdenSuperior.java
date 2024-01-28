/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funcionordensuperior;

import java.util.function.Function; //Representa una funcion que es la funcion, function es la que toma como argumento esta funcion y genera un calculo y se operaliza mediante el 

public class FuncionOrdenSuperior {

    public static void main(String[] args) {
        //es una funcion de orden superior que toma como argumento una funcion FUNCTION
        Function<Integer, Integer> cuadrado = x -> x*x;
        System.out.println(funcionArgumento(cuadrado, 25)); //25*25
    }
        
        public static int funcionArgumento(Function<Integer, Integer> funcion, int numero){
            return funcion.apply(numero);
        }
        
        
    }
   
