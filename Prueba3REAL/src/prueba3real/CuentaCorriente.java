/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba3real;

public class CuentaCorriente {
    private double saldo; // Variable privada que almacena el saldo de la cuenta corriente.

    // Constructor que inicializa una cuenta corriente con un saldo inicial proporcionado.
    public CuentaCorriente(double saldoInicial) {
        this.saldo = saldoInicial; // Inicializa el saldo de la cuenta con el saldo inicial proporcionado.
    }

    // Método para obtener el saldo actual de la cuenta corriente.
    public double getSaldo() {
        return saldo; // Devuelve el saldo actual de la cuenta.
    }

    // Método para establecer un nuevo saldo en la cuenta corriente.
    public void setSaldo(double nuevoSaldo) {
        this.saldo = nuevoSaldo; // Establece el saldo de la cuenta con el nuevo saldo proporcionado.
    }

    // Método para depositar una cantidad en la cuenta corriente.
    public void depositar(double cantidad) {
        saldo += cantidad; // Incrementa el saldo de la cuenta por la cantidad proporcionada.
    }

    // Método para retirar una cantidad de la cuenta corriente.
    public void retirar(double cantidad) {
        saldo -= cantidad; // Reduce el saldo de la cuenta por la cantidad proporcionada.
    }

    // Método para actualizar el saldo de la cuenta corriente agregando o restando una cantidad.
    public void actualizarSaldo(double cantidad) {
        saldo += cantidad; // Suma la cantidad proporcionada al saldo existente.
    }
}