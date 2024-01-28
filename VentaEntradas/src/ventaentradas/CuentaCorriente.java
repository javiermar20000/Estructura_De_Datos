package ventaentradas;

public class CuentaCorriente {
    private String nombreUsuario;
    private int cantidadTicketsComprados;

    public CuentaCorriente(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.cantidadTicketsComprados = 0;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getCantidadTicketsComprados() {
        return cantidadTicketsComprados;
    }

    public synchronized boolean comprarTickets(Entrada entrada, int cantidad) {
        if (entrada.comprarEntrada(cantidad)) {
            cantidadTicketsComprados += cantidad;
            return true;
        }
        return false;
    }
}