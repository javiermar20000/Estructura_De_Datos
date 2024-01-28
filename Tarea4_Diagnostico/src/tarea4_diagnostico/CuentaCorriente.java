package tarea4_diagnostico;

public class CuentaCorriente {
    private double saldo;
    private double lineaCredito = 1500000;

    public CuentaCorriente(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLineaCredito() {
        return lineaCredito;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void girar(double monto) {
        double disponible = saldo + lineaCredito;
        if (monto <= disponible) {
            saldo -= monto;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void transferir(CuentaCorriente destino, double monto) {
        double disponible = saldo + lineaCredito;
        if (monto <= disponible) {
            saldo -= monto;
            destino.depositar(monto);
        } else {
            System.out.println("Saldo insuficiente para transferir esa cantidad.");
        }
    }
}

