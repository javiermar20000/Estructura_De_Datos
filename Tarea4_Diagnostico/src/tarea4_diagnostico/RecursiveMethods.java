
package tarea4_diagnostico;

import java.util.List;

public class RecursiveMethods {
   
    
    public static void depositar(List<Cuenta> cuentas, LineaDeCredito lineaDeCredito, LineaDeCredito lineaDeCredito2, int numCuentaDeposito1, double monto, Registro registro) {
    if (monto <= 0) {
        System.out.println("El monto del depósito debe ser mayor que 0.");
        return; // Salir del método si el monto no es válido
    }

    if (numCuentaDeposito1 == 1) {
        if (monto <= lineaDeCredito.getSaldo()) {
            Cuenta cuentaDeposito = buscarCuentaPorNumero(cuentas, numCuentaDeposito1);
            if (cuentaDeposito != null) {
                cuentaDeposito.getCuentaCorriente().depositar(monto);
                registro.agregarRegistro("Depósito en cuenta " + numCuentaDeposito1 + ",+$" + monto + " desde línea de crédito 1");
                System.out.println("Depósito exitoso en la cuenta " + numCuentaDeposito1 + ".");
                lineaDeCredito.depositar(monto);
            } else {
                System.out.println("La cuenta no existe.");
            }
        } else {
            System.out.println("El monto del depósito excede el saldo de la línea de crédito 1.");
        }
    } else if (numCuentaDeposito1 == 2) {
        if (monto <= lineaDeCredito2.getSaldo()) {
            Cuenta cuentaDeposito = buscarCuentaPorNumero(cuentas, numCuentaDeposito1);
            if (cuentaDeposito != null) {
                cuentaDeposito.getCuentaCorriente().depositar(monto);
                registro.agregarRegistro("Depósito en cuenta " + numCuentaDeposito1 + ",+$" + monto + " desde línea de crédito 2");
                System.out.println("Depósito exitoso en la cuenta " + numCuentaDeposito1 + ".");
                lineaDeCredito2.depositar(monto);
            } else {
                System.out.println("La cuenta no existe.");
            }
        } else {
            System.out.println("El monto del depósito excede el saldo de la línea de crédito 2.");
        }
    }
}

    public static void girar(List<Cuenta> cuentas, int numCuentaGiro, double monto, Registro registro) {
    if (monto <= 0) {
        System.out.println("El monto del giro debe ser mayor que 0.");
        return; // Salir del método si el monto es menor o igual a 0.
    }

    Cuenta cuentaGiro = buscarCuentaPorNumero(cuentas, numCuentaGiro);
    if (cuentaGiro != null) {
        if (monto <= cuentaGiro.getCuentaCorriente().getSaldo()) {
            cuentaGiro.getCuentaCorriente().girar(monto);
            registro.agregarRegistro("Giro en cuenta " + numCuentaGiro + ", -$" + monto);
            System.out.println("Giro exitoso en la cuenta " + numCuentaGiro + ".");
        } else {
            System.out.println("El monto del giro excede el saldo de la cuenta.");
        }
    } else {
        System.out.println("La cuenta no existe.");
    }
}
    
    public static void transferir(List<Cuenta> cuentas, int numCuentaOrigen, int numCuentaDestino, double monto, Registro registro) {
    if (monto <= 0) {
        System.out.println("El monto de la transferencia debe ser mayor que 0.");
        return; // Salir del método si el monto no es válido
    }

    Cuenta cuentaOrigen = buscarCuentaPorNumero(cuentas, numCuentaOrigen);
    Cuenta cuentaDestino = buscarCuentaPorNumero(cuentas, numCuentaDestino);

    if (cuentaOrigen == null || cuentaDestino == null) {
        System.out.println("Una o ambas cuentas no existen.");
    } else {
        if (monto <= cuentaOrigen.getCuentaCorriente().getSaldo()) {
            cuentaOrigen.getCuentaCorriente().transferir(cuentaDestino.getCuentaCorriente(), monto);
            registro.agregarRegistro("Transferencia desde " + numCuentaOrigen + " hacia " + numCuentaDestino + ",-$" + monto);
            registro.agregarRegistro("Transferencia a " + numCuentaDestino + ",+$" + monto);
            System.out.println("Transferencia exitosa.");
        } else {
            System.out.println("El monto de la transferencia excede el saldo de la cuenta de origen.");
        }
    }
}
    
    public static void crearDepositoLargoPlazo(List<Cuenta> cuentas, int numCuentaDeposito, double monto, double tasaInteres, Registro registro) {
        Cuenta cuentaDeposito = buscarCuentaPorNumero(cuentas, numCuentaDeposito);

        if (cuentaDeposito != null) {
            if (monto <= cuentaDeposito.getCuentaCorriente().getSaldo()) {
                DepositoLargoPlazo deposito = new DepositoLargoPlazo(monto, tasaInteres);
                cuentaDeposito.setDepositoLargoPlazo(deposito);
                System.out.println("Depósito a Largo Plazo creado con éxito.");
                registro.agregarRegistroDepositoLargoPlazo(deposito);

                cuentaDeposito.getCuentaCorriente().girar(monto);
                registro.agregarRegistro("Giro de Depósito a Largo Plazo desde cuenta " + numCuentaDeposito + ",-$" + monto);
            } else {
                System.out.println("El monto del depósito a largo plazo excede el saldo de la cuenta asociada.");
            }
        } else {
            System.out.println("La cuenta no existe.");
        }
    }
    
    public static void retirarDepositoLargoPlazo(List<Cuenta> cuentas, int numCuentaRetiro, Registro registro) {
        Cuenta cuentaRetiroDeposito = buscarCuentaPorNumero(cuentas, numCuentaRetiro);

        if (cuentaRetiroDeposito != null) {
            DepositoLargoPlazo depositoLargoPlazo = cuentaRetiroDeposito.getDepositoLargoPlazo();

            if (depositoLargoPlazo != null) {
                if (depositoLargoPlazo.retirar()) {
                    double montoRetirado = depositoLargoPlazo.getMonto();
                    cuentaRetiroDeposito.getCuentaCorriente().depositar(montoRetirado);
                    registro.agregarRegistro("Retiro de Depósito a Largo Plazo desde cuenta " + numCuentaRetiro + ", +$" + montoRetirado);
                    System.out.println("Retiro de Depósito a Largo Plazo exitoso.");
                }
            } else {
                System.out.println("La cuenta no tiene un Depósito a Largo Plazo.");
            }
        } else {
            System.out.println("La cuenta no existe.");
        }
    }

    private static Cuenta buscarCuentaPorNumero(List<Cuenta> cuentas, int numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                return cuenta;
            }
        }
        return null;
    }
}