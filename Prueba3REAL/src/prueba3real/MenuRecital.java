
package prueba3real;

//Integrante: Javier Martínez

import java.util.Scanner; //utilizamos esta libreria para que el usuario pueda escribir
import prueba3real.interfazGrafica.MenuRecitalGUI;

public class MenuRecital {
    public static void main(String[] args) {
        MenuRecitalGUI menu = new MenuRecitalGUI(); //cargar interfaz grafica
        menu.main(new String[]{});
        // Crear una instancia del sistema de gestión de recital
        GestionRecital sistemaRecital = new GestionRecital();
        // Crear un objeto Scanner para entrada de usuario
        Scanner scanner = new Scanner(System.in);
        int opcion = 0; // Variable para almacenar la opción del menú seleccionada por el usuario

        // Crear y asociar cuentas corrientes a los compradores y al vendedor
        CuentaCorriente cuentaZatiel = new CuentaCorriente(1500000);
        CuentaCorriente cuentaAngel = new CuentaCorriente(1500000);
        CuentaCorriente cuentaMiguel = new CuentaCorriente(1500000);
        CuentaCorriente cuentaVendedor = new CuentaCorriente(0); // Cuenta del vendedor con saldo inicial cero
        

        // Asociar cuentas corrientes a los compradores y al vendedor en el sistema de recital
        sistemaRecital.asociarCuentaCorriente("zatiel", cuentaZatiel);
        sistemaRecital.asociarCuentaCorriente("angel", cuentaAngel);
        sistemaRecital.asociarCuentaCorriente("miguel", cuentaMiguel);
        sistemaRecital.asociarCuentaCorriente("vendedor", cuentaVendedor); // Asociar cuenta del vendedor
        
        System.out.println("¡Bienvenidos al sistema de compra de entradas para el Recital OwO!");
        // panel de opciones para el usuario
        while (opcion != 6) { // mientras la opcion NO sea 6, si es 6, salir del ciclo while
            System.out.println("---------------------------------------------");
            System.out.println("Menú:");
            System.out.println("1. Comprar entrada");
            System.out.println("2. Realizar/confirmar pago");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Ver entradas compradas");
            System.out.println("5. Cancelar entrada y obtener reembolso");
            System.out.println("6. Salir");
            System.out.print("Ingrese el número de la opción: ");
            opcion = scanner.nextInt(); // Leer la opción ingresada por el usuario

            switch (opcion) {
                case 1:
                    // Comprar entrada
                    System.out.println("Precio de la entrada: 10000 CLP");
                    System.out.print("Ingrese el nombre del comprador (zatiel, angel, miguel): ");
                    String nombreComprador = scanner.next().toLowerCase();
                    sistemaRecital.comprarEntrada(nombreComprador, scanner);
                    break;
                case 2:
                    // Realizar pago
                    sistemaRecital.realizarPago(scanner);
                    break;
                case 3:
                    // Consultar saldo
                    System.out.print("Ingrese el nombre del comprador para consultar el saldo (zatiel, angel, miguel, vendedor): ");
                    String nombreConsultar = scanner.next().toLowerCase();
                    sistemaRecital.consultarSaldo(nombreConsultar);
                    break;
                case 4:
                    // Ver entradas compradas
                    sistemaRecital.verEntradasCompradas();
                    break;
                case 5:
                    // Cancelar entrada y obtener reembolso
                    System.out.print("Ingrese el nombre del comprador para cancelar la entrada: ");
                    String nombreCancelar = scanner.next().toLowerCase(); // Normalizar el nombre
                    sistemaRecital.cancelarEntrada(nombreCancelar);
                    break;
                case 6:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    // Opción inválida
                    System.out.println("Opción inválida.");
                    break;
            }
        }
        
        // Operaciones finales después de salir del bucle
        sistemaRecital.generarBoleta(); // Llamada al método para generar la boleta
        double gananciaVendedor = sistemaRecital.calcularGananciaVendedor();
        System.out.println("Ganancia total del vendedor: $" + gananciaVendedor + " CLP");

        scanner.close(); // Cerrar el Scanner
    }
}