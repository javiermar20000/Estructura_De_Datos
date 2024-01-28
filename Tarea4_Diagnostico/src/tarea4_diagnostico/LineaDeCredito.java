package tarea4_diagnostico;


public class LineaDeCredito {
    private double saldo;

    public LineaDeCredito(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo -= monto; // Resta el monto depositado de la línea de crédito
        }
    }
}