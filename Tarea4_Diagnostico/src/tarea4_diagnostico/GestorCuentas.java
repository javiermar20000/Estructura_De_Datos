
package tarea4_diagnostico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GestorCuentas {
    public static void cargarCuentasDesdeArchivo(String nombreArchivo, Queue<Cuenta> cuentas) {
        try {
            File archivo = new File(nombreArchivo);
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNext()) {
                String linea = scanner.nextLine();
                // Elimina los corchetes y separa por comas
                String[] numeros = linea.substring(1, linea.length() - 1).split(",");

                for (String numero : numeros) {
                    cuentas.offer(new Cuenta(Integer.parseInt(numero), 0)); // Agregar al final de la cola
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("¡El archivo no pudo ser encontrado!");
            e.printStackTrace();
        }
    }

    public static void venderEntradas(Queue<Cuenta> cuentas, Registro registro) {
    Scanner scanner = new Scanner(System.in);

    int numEntradas;
    do {
        System.out.print("Ingrese la cantidad de entradas a vender (máximo 20): ");
        numEntradas = scanner.nextInt();

        if (numEntradas < 1) {
            System.out.println("El valor de entradas debe ser 1 o superior. Inténtelo de nuevo.");
        }
    } while (numEntradas < 1);

    int totalEntradasVendidas = 0;

    while (totalEntradasVendidas < 20 && numEntradas > 0 && !cuentas.isEmpty()) {
        // Verificar si el número de entradas a vender supera el límite de 20 en total
        if (totalEntradasVendidas + numEntradas > 20) {
            System.out.println("Se ha excedido el límite de 20 entradas en total. Venta restringida.");
            break;
        }

        // Limitar el número máximo de entradas a vender por iteración a 20
        int entradasAVender = Math.min(numEntradas, 20);

        // Lógica de venta de entradas
        for (int i = 0; i < entradasAVender; i++) {
            Cuenta cliente = cuentas.poll(); // Tomar al cliente del principio de la cola
            System.out.println("Venta realizada al cliente de la cuenta: " + cliente.getNumeroCuenta());
            
            // Registrar la venta en el archivo de registro
            registro.agregarRegistro("Venta de entrada al cliente " + cliente.getNumeroCuenta());
        }

        totalEntradasVendidas += entradasAVender;
        numEntradas -= entradasAVender;

        System.out.println("Total de cuentas de clientes que quedan en la cola: " + cuentas.size());
    }
}

    public static void mostrarCuentasAlPrincipioYFinal(List<Cuenta> cuentas) {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas cargadas.");
            return;
        }

        Cuenta clienteAlPrincipio = cuentas.get(0);
        Cuenta clienteAlFinal = cuentas.get(cuentas.size() - 1);

        System.out.println("Cuenta de cliente al principio de la cola: " + clienteAlPrincipio.getNumeroCuenta());
        System.out.println("Cuenta de cliente al final de la cola: " + clienteAlFinal.getNumeroCuenta());
    }
}