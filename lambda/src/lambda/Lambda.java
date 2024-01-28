package lambda;
interface calculo{ // es un tipo de dato abstracto
    int calcular(int x, int y);
}
        
        
public class Lambda {

    public static void main(String[] args) {
        //interpretacion de una interfaz abstacta, algo que me permite calcular
        //suponemos que podemos sumar o restar componentes
        //interfaz: metodo de interaccion
        calculo multi = (x,y)->x*y; // ----->> Esto es una funcion lambda, funcion de tipo oculta
                                    // o anonima
        
        System.out.println(multi.calcular(2, 5));
    }
    
}
