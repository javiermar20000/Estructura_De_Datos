package tarea4_pilas;

public class Usuario {
    private String nombre;
    private String cedula;
    private double lineaCredito;

    public Usuario(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.lineaCredito = 1500000.0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public double getLineaCredito() {
        return lineaCredito;
    }
}