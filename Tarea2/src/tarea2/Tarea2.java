package tarea2;
import java.util.Stack;

//Tarea N°2 Corregir codigo utilizando Stack
//el error era excepción de tipo ArrayIndexOutOfBoundsException.
//se corrige proporcionando argumento antes de ejecutar el programa

public class Tarea2 {

   public static void main(String[] args) {
    Stack<String> st = new Stack<>();
    st.push("Hola Mundo!!!!!!");
    
    if (args.length > 0) {
        st.push(args[0]);
    }
    
    String s;
    
    while (!st.isEmpty()) {
        s = st.pop();
        System.out.println(s);
    }
}
}