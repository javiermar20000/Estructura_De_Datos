
package prueba3real;

class Entrada {
    String comprador; // Variable que almacena el nombre del comprador de la entrada.
    double precio; // Variable que registra el precio de la entrada.

    // Constructor que inicializa un objeto Entrada con un comprador y un precio fijo.
    public Entrada(String comprador) {
        this.comprador = comprador; // Asigna el nombre del comprador proporcionado al atributo comprador.
        this.precio = 10000; // Asigna un precio fijo de $10000 al atributo precio de la entrada.
    }
}