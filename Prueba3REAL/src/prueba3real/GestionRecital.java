/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba3real;

import java.util.ArrayList; // para utilizar listas dinámicas (ArrayList)
import java.util.Comparator; // interfaz Comparator para comparar objetos y ordenar listas o colecciones
import java.util.HashMap; // tabla hash, una estructura de datos clave-valor
import java.util.LinkedList; // listas doblemente enlazadas, inserción y eliminación en cualquier posición.
import java.util.List; // manipular colecciones ordenadas de elementos
import java.util.Map; // estructuras de datos clave-valor, clave-valor
import java.util.Queue; // implementar colas FIFO (First-In-First-Out).
import java.util.Scanner; // leer datos de entrada del usuario
import java.util.Stack; // pila (stack), LIFO (Last-In-First-Out).
import java.io.BufferedWriter; // Proporciona clases para escribir datos en un búfer de caracteres
import java.io.FileWriter; // Permitir escribir y crear un txt
import java.io.IOException; // excepciones de entrada/salida

class GestionRecital {
    // Estructuras de datos utilizadas en la gestión del recital
    Stack<Entrada> entradas = new Stack<>();
    Queue<Double> pagos = new LinkedList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    HashMap<String, Integer> compradoresConEntradas = new HashMap<>();
    HashMap<String, CuentaCorriente> cuentasCorrientes = new HashMap<>(); // Asociar cuentas corrientes a compradores
    HashMap<String, Integer> comprasConfirmadas = new HashMap<>();
    boolean pagoRealizado = false;

    // Método para asociar cuentas corrientes a los compradores en el sistema de recital
    public void asociarCuentaCorriente(String nombreComprador, CuentaCorriente cuenta) {
        cuentasCorrientes.put(nombreComprador, cuenta);
    }

    // Método para ordenar las entradas por nombre del comprador
    public void ordenarEntradasPorNombre() {
        entradas.sort(Comparator.comparing(e -> e.comprador));
    }

    // Método para agregar compradores con cantidad de entradas compradas
    public void agregarCompradorConEntradas(String comprador, int cantidadEntradas) {
        compradoresConEntradas.put(comprador, cantidadEntradas);
    }

    // Método para realizar la compra de entradas
    public void comprarEntrada(String comprador, Scanner scanner) {
    System.out.print("Ingrese la cantidad de entradas a comprar: ");
    int cantidadEntradas = scanner.nextInt();

    // Modificar para agregar la compra a una estructura temporal
    if (compradoresConEntradas.containsKey(comprador)) {
        int cantidadActual = compradoresConEntradas.get(comprador);
        compradoresConEntradas.put(comprador, cantidadActual + cantidadEntradas);
    } else {
        compradoresConEntradas.put(comprador, cantidadEntradas);
    }

    // Agregar las entradas a la pila de entradas
    for (int i = 0; i < cantidadEntradas; i++) {
        entradas.push(new Entrada(comprador));
    }

    // Mostrar mensaje de compra pendiente de confirmación
    System.out.println("¡Entradas compradas pendientes de confirmación!");
}

    public void realizarPago(Scanner scanner) {
    if (!compradoresConEntradas.isEmpty()) {
        System.out.println("¿Desea confirmar las compras? (si/no)");
        String confirmacion = scanner.next().toLowerCase();

        if (confirmacion.equals("si")) {
            double totalDinero = 0; // Total de dinero generado por las compras

            for (Map.Entry<String, Integer> entry : compradoresConEntradas.entrySet()) {
                String comprador = entry.getKey();
                int cantidadEntradas = entry.getValue();
                confirmarCompra(comprador, cantidadEntradas);

                // Actualizar el saldo en la cuenta corriente del comprador
                CuentaCorriente cuenta = cuentasCorrientes.get(comprador);
                cuenta.actualizarSaldo(-cantidadEntradas * 10000);

                totalDinero += cantidadEntradas * 10000;

                // Actualizar el mapa entradasCompradasPorComprador
                if (entradasCompradasPorComprador.containsKey(comprador)) {
                    int cantidadActual = entradasCompradasPorComprador.get(comprador);
                    entradasCompradasPorComprador.put(comprador, cantidadActual + cantidadEntradas);
                } else {
                    entradasCompradasPorComprador.put(comprador, cantidadEntradas);
                }
            }

            // Actualizar el saldo del vendedor una vez que se han confirmado las compras
            if (comprasConfirmadas.containsKey("vendedor")) {
                CuentaCorriente cuentaVendedor = cuentasCorrientes.get("vendedor");
                cuentaVendedor.actualizarSaldo(totalDinero); // Sumar el total de dinero al saldo del vendedor
            }

            compradoresConEntradas.clear();
            System.out.println("¡Compras confirmadas!");
        } else {
            compradoresConEntradas.clear();
            System.out.println("Compra no confirmada. No se han restado fondos de la cuenta corriente.");
        }
    } else {
        System.out.println("No hay compradores con entradas a confirmar al realizar el pago.");
    }
}

    public double consultarSaldo(String nombreComprador) {
        if (cuentasCorrientes.containsKey(nombreComprador)) {
            CuentaCorriente cuenta = cuentasCorrientes.get(nombreComprador);
            double saldo = cuenta.getSaldo();
            if (nombreComprador.equals("vendedor")) {
                double gananciaVendedor = calcularGananciaVendedor();
                System.out.println("Saldo en la cuenta corriente del vendedor: $"+gananciaVendedor);
            } else {
            System.out.println("Saldo de la cuenta de " + nombreComprador + ":$ " + saldo);
            return saldo;
        } 
    }  
        return 0;
}

    private void confirmarCompra(String comprador, int cantidadEntradas) {
        System.out.println("Compra confirmada para " + comprador + " - Cantidad de entradas: " + cantidadEntradas);
    }

    HashMap<String, Integer> entradasCompradasPorComprador = new HashMap<>();

public void verEntradasCompradas() {
    if (!entradasCompradasPorComprador.isEmpty()) {
        // Convertir el conjunto de entradas del mapa en una lista
        List<Map.Entry<String, Integer>> listaEntradas = new ArrayList<>(entradasCompradasPorComprador.entrySet());

        // Ordenar la lista alfabéticamente
        listaEntradas.sort(Map.Entry.comparingByKey());

        System.out.println("Compras confirmadas:");
        for (Map.Entry<String, Integer> entry : listaEntradas) {
            String comprador = entry.getKey();
            int cantidad = entry.getValue();
            double costoTotal = cantidad * 10000;
            System.out.println("Comprador: " + comprador + " - Entradas: " + cantidad + " - Costo: " + costoTotal + " CLP");
        }
    } else {
        System.out.println("No hay compras confirmadas.");
    }
}

    public void cancelarEntrada(String comprador) {
   boolean comprasPendientes = compradoresConEntradas.containsKey(comprador) && compradoresConEntradas.get(comprador) > 0;

   if (comprasPendientes) {
       if (!pagoRealizado) {
           boolean entradaEncontrada = false;
           Stack<Entrada> nuevasEntradas = new Stack<>();

           // Normalizar el nombre del comprador
           comprador = comprador.toLowerCase(); // Convertir a minúsculas

           // Buscar la entrada del comprador para cancelar
           while (!entradas.isEmpty()) {
              Entrada actual = entradas.pop();
              if (!actual.comprador.toLowerCase().equals(comprador)) {
                 nuevasEntradas.push(actual);
              } else {
                 entradaEncontrada = true;
                 // Restaurar la cantidad de entradas disponibles al cancelar una entrada
                 int cantidadEntradasRestantes = compradoresConEntradas.get(comprador);
                 compradoresConEntradas.put(comprador, cantidadEntradasRestantes - 1);
              }
           }

           // Restaurar las entradas no canceladas a la pila
           while (!nuevasEntradas.isEmpty()) {
              entradas.push(nuevasEntradas.pop());
           }

           // Si se encontró la entrada, se cancela. De lo contrario, mostrar mensaje.
           if (entradaEncontrada) {
              System.out.println("Entrada cancelada para " + comprador);
              // Eliminar el comprador de la lista de compradores con entradas
              compradoresConEntradas.remove(comprador);
           } else {
              System.out.println("Error al cancelar la entrada. Entrada no encontrada.");
           }
       } else {
           System.out.println("No se puede obtener un reembolso después de confirmar el pago.");
       }
   } else {
       System.out.println("El comprador no tiene una entrada pendiente.");
   }
}
    
    double calcularGananciaVendedor() {
        double totalGananciaVendedor = 0;
        for (Map.Entry<String, Integer> entry : entradasCompradasPorComprador.entrySet()) {
            String comprador = entry.getKey();
            int cantidadEntradas = entry.getValue();
            if (!comprador.equals("vendedor")) {
                totalGananciaVendedor += cantidadEntradas * 10000;
            }
        }
        return totalGananciaVendedor;
    }

    // Nuevo método para generar la boleta y mostrar la ganancia del vendedor
    public void generarBoleta() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("boleta.txt"))) {
        if (!entradasCompradasPorComprador.isEmpty()) {
            // Convertir el conjunto de entradas del mapa en una lista
            List<Map.Entry<String, Integer>> listaEntradas = new ArrayList<>(entradasCompradasPorComprador.entrySet());

            // Ordenar la lista alfabéticamente
            listaEntradas.sort(Map.Entry.comparingByKey());

            writer.write("Compras confirmadas:\n");
            for (Map.Entry<String, Integer> entry : listaEntradas) {
                String comprador = entry.getKey();
                int cantidad = entry.getValue();
                double costoTotal = cantidad * 10000;
                writer.write("Comprador: " + comprador + " - Entradas: " + cantidad + " - Costo: " + costoTotal + " CLP\n");
            }

            writer.write("\n------------------------------------------------------------\n");
            writer.write("-------------------------------------------------------------\n");

            // Incluir información sobre el saldo de los compradores y la pérdida total
            double totalPerdida = 0;
            String compradorConMayorPerdida = null;
            double mayorPerdida = 0;

            for (Map.Entry<String, CuentaCorriente> entry : cuentasCorrientes.entrySet()) {
                String comprador = entry.getKey();
                if (!comprador.equals("vendedor")) {
                    CuentaCorriente cuenta = entry.getValue();
                    double saldo = cuenta.getSaldo();
                    double perdida = saldo - 1500000; // 1500000 es el saldo inicial
                    totalPerdida += perdida;

                    if (perdida > mayorPerdida) {
                        mayorPerdida = perdida;
                        compradorConMayorPerdida = comprador;
                    }

                    writer.write("Saldo de " + comprador + " en cuenta corriente: $" + saldo + " CLP - Pérdida: $" + perdida + " CLP\n");
                }
            }

            double gananciaVendedor = calcularGananciaVendedor();
            writer.write("\nGanancia del vendedor: $" + gananciaVendedor + " CLP\n");
            writer.write("Total pérdida de los compradores: $" + totalPerdida + " CLP\n");
            
            if (compradorConMayorPerdida != null) {
                writer.write("Comprador con mayor pérdida: " + compradorConMayorPerdida + " - Pérdida: $" + mayorPerdida + " CLP\n");
            }

            System.out.println("Boleta generada correctamente en el archivo boleta.txt");
        } else {
            writer.write("No hay compras confirmadas.\n");
        }
    } catch (IOException e) {
        System.err.println("Error al generar la boleta: " + e.getMessage());
    }
}

}