package ventaentradas;

public class Main {
    public static void main(String[] args) {
        Entrada entradas = new Entrada();
        VentaEntradas venta = new VentaEntradas();

        for (int i = 1; i <= 5000; i++) {
            CuentaCorriente cuenta = new CuentaCorriente("Cliente" + i);
            venta.unirseACola(cuenta);
        }

        while (entradas.hayEntradasDisponibles() && !venta.colaVacia()) {
            venta.comprarSiguiente(entradas);
        }

        if (!entradas.hayEntradasDisponibles()) {
            System.out.println("¡Todas las entradas se han agotado!");
            int usuariosEnEspera = venta.obtenerCantidadUsuariosEnEspera();
            System.out.println("Clientes en cola esperando: " + usuariosEnEspera);
        }
    }
}