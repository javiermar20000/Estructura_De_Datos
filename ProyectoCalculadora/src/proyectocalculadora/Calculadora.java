package proyectocalculadora;

public class Calculadora {
    //Primero Crear los atributos
    private int operando1;
    private int operando2;
    
    //Luego los constructores
    public Calculadora(){
        
    }
    
    public Calculadora(int operando1, int operando2) {
        this.operando1 = operando1;
        this.operando2 = operando2;
    }
    
    //Métodos de las operaciones solicitadas
    
    public int sumar(){
        int suma = this.operando1 + this.operando2;
        return suma;
    }
    
    public int restar(){
        int restar = this.operando1 - this.operando2;
        return restar;
    }
    
    public int multiplicar(){
        int multiplicacion = this.operando1 * this.operando2;
        return multiplicacion;
    }
    
    public double dividir(){
        double dividir = this.operando1 / this.operando2;
        return dividir;
    }

    public int getOperando1() {
        return operando1;
    }

    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }

    public int getOperando2() {
        return operando2;
    }

    public void setOperando2(int operando2) {
        this.operando2 = operando2;
    }
    
    
}
