package tarea4_diagnostico;

public class Cuenta {
    private int numeroCuenta;
    private double saldo;
    private DepositoLargoPlazo depositoLargoPlazo;
    private CuentaCorriente cuentaCorriente;

    public Cuenta(int numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.cuentaCorriente = new CuentaCorriente(saldoInicial);
    }

    public Cuenta(int numeroCuenta, double saldo, DepositoLargoPlazo depositoLargoPlazo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.depositoLargoPlazo = depositoLargoPlazo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public DepositoLargoPlazo getDepositoLargoPlazo() {
        return depositoLargoPlazo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void girar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }
    
     public void setDepositoLargoPlazo(DepositoLargoPlazo depositoLargoPlazo) {
        this.depositoLargoPlazo = depositoLargoPlazo;
    }
}
