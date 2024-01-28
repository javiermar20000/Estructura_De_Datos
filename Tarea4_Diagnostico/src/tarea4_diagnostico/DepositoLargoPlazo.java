package tarea4_diagnostico;

import java.util.Stack;

public class DepositoLargoPlazo {
    private double monto;
    private Stack<Integer> diasTranscurridos;
    private double tasaInteres;

    public DepositoLargoPlazo(double monto, double tasaInteres) {
        this.monto = monto;
        this.tasaInteres = tasaInteres;
        this.diasTranscurridos = new Stack<>();
    }

    public double getMonto() {
        return monto;
    }
    
    public double getTasaInteres() {
        return tasaInteres;
    }
    
    public int getDiasTranscurridos() {
        return diasTranscurridos.size();
    }
    
    public double calcularIntereses() {
        int totalDias = diasTranscurridos.stream().mapToInt(Integer::intValue).sum();
        return monto * (tasaInteres / 100) * (totalDias / 365.0);
    }

    public boolean retirar() {
        if (getDiasTranscurridos() >= 30) {
            return true;
        } else {
            System.out.println("El depósito a largo plazo no puede ser retirado antes de 30 días.");
            return false;
        }
    }

    public void avanzarDia() {
        diasTranscurridos.push(1); // Agrega un día a la pila
    }

    public void retrocederDia() {
        if (!diasTranscurridos.isEmpty()) {
            diasTranscurridos.pop(); // Elimina el último día de la pila
        }
    }
}
