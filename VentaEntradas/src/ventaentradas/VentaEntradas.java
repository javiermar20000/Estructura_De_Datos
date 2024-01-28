package ventaentradas;

import java.util.Queue;
import java.util.LinkedList;

public class VentaEntradas {
    private Queue<CuentaCorriente> colaDeEspera;

    public VentaEntradas() {
        colaDeEspera = new LinkedList<>();
    }

    public synchronized void unirseACola(CuentaCorriente cuentaCorriente) {
        colaDeEspera.add(cuentaCorriente);
        System.out.println(cuentaCorriente.getNombreUsuario() + " se ha unido a la cola.");
        mostrarEstadoCola();
    }

    public synchronized void comprarSiguiente(Entrada entrada) {
        int entradasDisponiblesPorIteracion = 20;
        for (int i = 0; i < entradasDisponiblesPorIteracion; i++) {
            CuentaCorriente siguienteCliente = colaDeEspera.peek();
            if (siguienteCliente != null && entrada.hayEntradasDisponibles()) {
                boolean compraExitosa = siguienteCliente.comprarTickets(entrada, 1);
                if (compraExitosa) {
                    colaDeEspera.poll(); // Remover usuario solo si la compra fue exitosa
                    System.out.println(siguienteCliente.getNombreUsuario() + " ha comprado 1 entrada y ha salido de la cola.");
                }
            } else {
                break; // Si no hay más entradas o usuarios en la cola
            }
        }
        mostrarEstadoCola();
    }

    public boolean colaVacia() {
        return colaDeEspera.isEmpty();
    }

    public int obtenerCantidadUsuariosEnEspera() {
        return colaDeEspera.size();
    }

    public void mostrarEstadoCola() {
        mostrarPrimerUsuario();
        mostrarUltimoUsuario();
        System.out.println("--------------------------------------------------------------");
        }
    
    public void mostrarPrimerUsuario() {
        CuentaCorriente primerUsuario = colaDeEspera.peek();
        System.out.println("Primer cliente en la cola: " + (primerUsuario != null ? primerUsuario.getNombreUsuario() : "No hay usuarios"));
    }
    

    public void mostrarUltimoUsuario() {
        CuentaCorriente ultimoUsuario = null;
        for (CuentaCorriente cuenta : colaDeEspera) {
            ultimoUsuario = cuenta;
        }
        System.out.println("Último cliente en la cola: " + (ultimoUsuario != null ? ultimoUsuario.getNombreUsuario() : "No hay usuarios"));
    }
}