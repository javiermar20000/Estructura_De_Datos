package prueba3real;

class Usuario {
    String nombre; // Variable que almacena el nombre del usuario.
    double saldo; // Variable que registra el saldo del usuario.

    // Constructor que inicializa un objeto Usuario con un nombre y un saldo.
    public Usuario(String nombre, double saldo) {
        this.nombre = nombre; // Asigna el nombre proporcionado al atributo nombre del usuario.
        this.saldo = saldo; // Asigna el saldo proporcionado al atributo saldo del usuario.
    }
}