package tarea3;

class cociente {
    private int numerador;
    private int denominador;
    private int cantidad_cociente = 0;
    
    public cociente(int numerador, int denominador) {
        this.numerador = numerador;
        if (denominador != 0) {
            this.denominador = denominador;
        } else {
            this.denominador = 1;
        }
        cantidad_cociente++;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int getCantidad_cociente() {
        return cantidad_cociente;
    }

    public void setCantidad_cociente(int cantidad_cociente) {
        this.cantidad_cociente = cantidad_cociente;
    }
    
    public cociente multiplicar(cociente dos) {
        int sup = this.numerador * dos.numerador;
        int inf = this.denominador * dos.denominador;
        cociente mult = new cociente(sup, inf);
        return mult;
    }
    
    public cociente suma(cociente dos) {
        int sup = this.numerador * dos.denominador + this.denominador * dos.numerador;
        int inf = this.denominador * dos.denominador;
        cociente suma = new cociente(sup, inf);
        return suma;
    }
    
    public cociente resta(cociente dos) {
        int sup = this.numerador * dos.denominador - this.denominador * dos.numerador;
        int inf = this.denominador * dos.denominador;
        cociente resta = new cociente(sup, inf);
        return resta;
    }
    
    public cociente dividir(cociente dos) {
        int sup = this.numerador * dos.denominador;
        int inf = this.denominador * dos.numerador;
        cociente dividir = new cociente(sup, inf);
        return dividir;
    }
    
    public String toString() {
        return "(" + this.numerador + "/" + this.denominador + ")";
    }
}
