package tarea4_pilas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Tarea4_Pilas {
    public static void main(String[] args) {
        RegistroUsuarios registro = new RegistroUsuarios();
        Stack<String> registros = new Stack<>();

        // Agregar usuarios de ejemplo
        Usuario usuario1 = new Usuario("Juan Pérez", "123456789");
        Usuario usuario2 = new Usuario("María Gómez", "987654321");
        registro.agregarUsuario(usuario1);
        registro.agregarUsuario(usuario2);

        // Crear cuentas corrientes para los usuarios
        CuentaCorriente cuenta1 = new CuentaCorriente(usuario1);
        CuentaCorriente cuenta2 = new CuentaCorriente(usuario2);

        // Realizar operaciones en las cuentas corrientes
        cuenta1.depositar(200000.0);
        cuenta1.girar(150000.0);
        cuenta1.transferir(cuenta2, 100000.0);

        // Registrar operaciones en pila
        registros.push("Depósito: 200000.0");
        registros.push("Giro: 150000.0");
        registros.push("Transferencia de " + cuenta1.getSaldo() + " a " + cuenta2.getSaldo());

        // Almacenar registros en archivo .txt
        try (FileWriter writer = new FileWriter("registros.txt")) {
            while (!registros.isEmpty()) {
                writer.write(registros.pop() + "\n");
            }
            System.out.println("Registros almacenados en registros.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
