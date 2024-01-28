package tarea4_diagnostico;

//Tarea N°4: Diagnóstico:
//Integrante: Javier Alonso Martínez Sepúlveda -- Estructura de Datos
//agregar a este codigo el deposito a largo plazo mediante pilas, con push y pop:
//Cree un codigo en java usando POO (es decir, en varias clases distribuidas en varios codigos diferentes), 
//que cumpla con los siguientes requisitos:
//Que se almacene en un registro de texto plano (.txt) los depositos, giros, transferencias y depositos a largo plazo
//que se hayan realizado durante la ejecución del programa correspondiente.
//este programa debe tener 2 cuentas corrientes, debe permitir girar, depositar dinero. Y ademas transferir dinero
//de una cuenta personal o aun tercero (entre 2 cuentas), con validaciones correspondientes, cada usuario tendrá una 
//linea de crédito de $1.500.000, el programa debe ser capaz de mover dinero desde las lineas de crédito
//hacia las cuentas corrientes de los usuarios, se entrega el martes 08/08/2023
//Ademas crear Deposito A largo plazo con un retiro de 30 dias usando pilas (Evaluación 1)
//Ademas debe usar metodos recursivos en distintos codigos y llamarlos en la clase principal (esta de aqui)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//Esta es la clase principal
public class Tarea4_Diagnostico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Registro registro = new Registro("movimientos_bancarios.txt"); // para registrar las transferencias en un txt

        Queue<Cuenta> cuentas = new LinkedList<>(); // Cambio a Queue y uso de LinkedList
        GestorCuentas.cargarCuentasDesdeArchivo("arreglo.txt", cuentas);
        List<Cuenta> cuentas1 = new ArrayList<>();

        // Agregamos dos cuentas corrientes iniciales 1 y 2 con un saldo inicial de $0
        cuentas.offer(new Cuenta(1, 0)); // Utilizamos offer() en lugar de add()
        cuentas.offer(new Cuenta(2, 0));
        
        cuentas1.add(new Cuenta(1, 0));
        cuentas1.add(new Cuenta(2, 0));
        
        
        
        // Agregamos una línea de crédito por cada cuenta, con un saldo de $1500000 desde
        //donde podremos realizar los depositos hacia las cuentas corrientes correspondientes
        LineaDeCredito lineaDeCredito = new LineaDeCredito(1500000);
        LineaDeCredito lineaDeCredito2 = new LineaDeCredito(1500000);
        
        System.out.println("El total de cuentas de clientes cargados es: " + cuentas.size());
        


        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("Saldo actual cuenta corriente N1: $" + cuentas1.get(0).getCuentaCorriente().getSaldo()); //Obtener saldo cuenta1
            System.out.println("Saldo actual cuenta corriente N2: $" + cuentas1.get(1).getCuentaCorriente().getSaldo()); //obtener saldo cuenta2
            System.out.println("Saldo actual Linea de Credito N1: $" + lineaDeCredito.getSaldo()); // obtener saldo línea de crédito 1
            System.out.println("Saldo actual Linea de Credito N2: $" + lineaDeCredito2.getSaldo()); // obtener saldo línea de crédito 1
            System.out.println("--------------------------------------------------------");
            System.out.println("1. Depositar");
            System.out.println("2. Girar");
            System.out.println("3. Transferir");
            System.out.println("4. Crear Deposito a Largo Plazo");
            System.out.println("5. Retirar Deposito a Largo Plazo");
            System.out.println("6. Vender entradas concierto Bubble Sort");
            System.out.println("7. Mostrar Cola");
            System.out.println("8. Salir");
            System.out.print("Elija una opcion: ");
            int opcion = scanner.nextInt();
            double monto;

            switch (opcion) {
                case 1:
                    System.out.println("Seleccione la cuenta en la que desea realizar el depósito (1 o 2): ");
                    int numCuentaDeposito1 = scanner.nextInt();
                    System.out.print("Ingrese el monto a depositar: ");
                    monto = scanner.nextDouble();
                    RecursiveMethods.depositar(cuentas1, lineaDeCredito, lineaDeCredito2, numCuentaDeposito1, monto, registro);
                    break;

                case 2:
                    System.out.println("Seleccione la cuenta en la que desea realizar el giro (1 o 2): ");
                    int numCuentaGiro = scanner.nextInt();
                    System.out.print("Ingrese el monto a girar: ");
                    monto = scanner.nextDouble();
                    RecursiveMethods.girar(cuentas1, numCuentaGiro, monto, registro);
                    break;
                    
                case 3:
                    System.out.println("Existen dos numeros de cuentas, 1 y 2.");
                    System.out.print("Ingrese el número de cuenta de origen: ");
                    int numCuentaOrigen = scanner.nextInt();
                    System.out.print("Ingrese el número de cuenta de destino: ");
                    int numCuentaDestino = scanner.nextInt();
                    System.out.print("Ingrese el monto a transferir: ");
                    double monto1 = scanner.nextDouble();
                    RecursiveMethods.transferir(cuentas1, numCuentaOrigen, numCuentaDestino, monto1, registro);
                    break;
                    
                case 4:
                    System.out.print("Ingrese el monto para el Depósito a Largo Plazo: ");
                    double montoDeposito = scanner.nextDouble();

                    if (montoDeposito > 0) {
                        System.out.print("Ingrese la tasa de interés para el Depósito a Largo Plazo (%): ");
                        double tasaInteres = scanner.nextDouble();

                        if (tasaInteres > 0) {
                            System.out.print("Ingrese el número de cuenta para el Depósito a Largo Plazo: ");
                            int numCuentaDeposito = scanner.nextInt();

                            RecursiveMethods.crearDepositoLargoPlazo(cuentas1, numCuentaDeposito, montoDeposito, tasaInteres, registro);
                        } else {
                            System.out.println("La tasa de interés debe ser mayor que cero.");
                        }
                    } else {
                        System.out.println("El monto del depósito a largo plazo debe ser mayor que cero.");
                    }
                    break;
                    
                case 5:
                    System.out.println("Seleccione la cuenta desde la cual desea retirar el Depósito a Largo Plazo (1 o 2): ");
                    int numCuentaRetiro = scanner.nextInt();
                    RecursiveMethods.retirarDepositoLargoPlazo(cuentas1, numCuentaRetiro, registro);
                    break;
                case 6:
                    // Llamada al método en la clase GestorCuentas
                    GestorCuentas.venderEntradas(cuentas, registro);
                    break;
                case 7:
                    // Llamada al método en la clase GestorCuentas
                    GestorCuentas.mostrarCuentasAlPrincipioYFinal((List<Cuenta>) cuentas);
                    break;
                case 8:
                    System.out.println("¡Hasta luego, vuelva pronto, le esperamos!");
                    return;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }
    }
}