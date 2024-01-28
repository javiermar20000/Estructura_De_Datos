package tarea4_pilas;

public class CuentaCorriente {
    private Usuario usuario;
    private double saldo;

    public CuentaCorriente(Usuario usuario) {
        this.usuario = usuario;
        this.saldo = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public boolean girar(double monto) {
        if (saldo + usuario.getLineaCredito() >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public void transferir(CuentaCorriente destino, double monto) {
        if (girar(monto)) {
            destino.depositar(monto);
        }
    }
}