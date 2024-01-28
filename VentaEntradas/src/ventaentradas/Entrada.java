package ventaentradas;

public class Entrada {
    private int capacidadMaxima = 2000;
    private int entradasDisponibles = capacidadMaxima;

    public boolean hayEntradasDisponibles() {
        return entradasDisponibles > 0;
    }

    public synchronized boolean comprarEntrada(int cantidad) {
        if (entradasDisponibles >= cantidad) {
            entradasDisponibles -= cantidad;
            return true;
        }
        return false;
    }
}