package tarea4_diagnostico;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro {
    private String filename;

    public Registro(String filename) {
        this.filename = filename;
    }

    public void agregarRegistro(String registro) {
        Date fecha = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaHora = formateador.format(fecha);

        try {
            FileWriter fw = new FileWriter(filename, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(fechaHora + "," + registro);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para agregar registros relacionados con el Depósito a Largo Plazo
    public void agregarRegistroDepositoLargoPlazo(DepositoLargoPlazo deposito) {
        Date fecha = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaHora = formateador.format(fecha);

        try {
            FileWriter fw = new FileWriter(filename, true);
            PrintWriter pw = new PrintWriter(fw);
            String registro = fechaHora + "," + "Depósito a Largo Plazo - Monto: $" + deposito.getMonto() + ", Tasa de Interés: " + deposito.getTasaInteres() + "%, Días: " + deposito.getDiasTranscurridos();
            pw.println(registro);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}