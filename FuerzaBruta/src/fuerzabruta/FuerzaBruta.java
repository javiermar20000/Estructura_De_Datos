//algoritmo de fuerza bruta
//siempre va a encontrar solucion al problema
//en cuanto a busqueda 0 ---> n - m
//----------------------------------------------
//entre m,as grande sea los datos en los dominios de busqueda, la busqueda sera mas grande y su timing demorara mas
//en resolver el problema.
//---------------------------------------------------------
//generar un paquete llamado: 
package fuerzabruta;


//algoritmo codigo de Fuerza Bruta, buscar un elemento (es un algoritmo secuencial)
//mecanismos de binarios, de arboles binarios, mejoran la eficiencia del codigo

public class FuerzaBruta {
    static int Fuerza_bruta(int[] lista, int abuscar){
        for (int i=0; i<lista.length;i++){
            if (lista[i]==abuscar){
                return i;
            }
        }
        return -1;
        
    }

    
    public static void main(String[] args) {
        int [] arreglo = {1,2,3,4,5,6,7,8,9};
        int valorbuscado=5;
        int resultbusqueda = Fuerza_bruta(arreglo, valorbuscado);
        
        if (resultbusqueda!=-1){
            System.out.println("El elemento buscado fue encontrado: "+resultbusqueda + ", considerando que las posiciones de la lista van de 0 a N");
        } else {
            System.out.println("El elemento buscado no se encuentra en la lista");
        }
        
        
        
    }
    
}