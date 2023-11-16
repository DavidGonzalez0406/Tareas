import java.io.*;
import java.util.Scanner;

public class Cajero {
    private static final String BILLETES_FILE = "billetes.dat";
    private static final String LOGS_FILE = "logs.txt";

    private static int billetes100;
    private static int billetes200;
    private static int billetes500;
    private static int billetes1000;

    static {
        inicializarBilletes();
    }

    public static void inicializarBilletes() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(BILLETES_FILE))) {
            billetes100 = inputStream.readInt();
            billetes200 = inputStream.readInt();
            billetes500 = inputStream.readInt();
            billetes1000 = inputStream.readInt();
        } catch (FileNotFoundException e) {
            inicializarBilletesDefault();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void inicializarBilletesDefault() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(BILLETES_FILE))) {
            billetes100 = 100;
            billetes200 = 100;
            billetes500 = 20;
            billetes1000 = 10;

            outputStream.writeInt(billetes100);
            outputStream.writeInt(billetes200);
            outputStream.writeInt(billetes500);
            outputStream.writeInt(billetes1000);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static int getBilletes100() {
        return billetes100;
    }

    public static int getBilletes200() {
        return billetes200;
    }

    public static int getBilletes500() {
        return billetes500;
    }

    public static int getBilletes1000() {
        return billetes1000;
    }

    public static void realizarAccionCajero(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAcciones disponibles:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar efectivo");
            System.out.println("3. Salir del cajero");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + usuario.getSaldo());
                    guardarLog("consultar", usuario.getNombre(), usuario.getSaldo(), "SI");
                    break;
                case 2:
                    System.out.println("Monto mínimo a retirar: $100");
                    System.out.print("Ingrese la cantidad a retirar: $");
                    double cantidadRetirar = scanner.nextDouble();

                    if (cantidadRetirar < 100 || cantidadRetirar > usuario.getSaldo()) {
                        System.out.println("Cantidad no válida. Intente de nuevo.");
                        guardarLog("retirar", usuario.getNombre(), cantidadRetirar, "NO");
                        continue;
                    }

                    if (!verificarBilletesDisponibles(cantidadRetirar)) {
                        System.out.println("No hay billetes disponibles para esa cantidad. Intente de nuevo.");
                        guardarLog("retirar", usuario.getNombre(), cantidadRetirar, "NO");
                        continue;
                    }

                    // Realizar el retiro
                    usuario.actualizarSaldo(cantidadRetirar);
                    actualizarBilletes();
                    guardarLog("retirar", usuario.getNombre(), cantidadRetirar, "SI");
                    System.out.println("Retiro exitoso. Nuevo saldo: $" + usuario.getSaldo());
                    break;
                case 3:
                    System.out.println("Saliendo del cajero. ¡Hasta luego, " + usuario.getNombre() + "!");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static boolean verificarBilletesDisponibles(double cantidad) {
        int[] denominaciones = {100, 200, 500, 1000};

        for (int i = denominaciones.length - 1; i >= 0; i--) {
            int denominacion = denominaciones[i];
            int cantidadBilletes = 0;

            switch (denominacion) {
                case 100:
                    cantidadBilletes = billetes100;
                    break;
                case 200:
                    cantidadBilletes = billetes200;
                    break;
                case 500:
                    cantidadBilletes = billetes500;
                    break;
                case 1000:
                    cantidadBilletes = billetes1000;
                    break;
            }

            int billetesNecesarios = (int) (cantidad / denominacion);
            int billetesUsados = Math.min(cantidadBilletes, billetesNecesarios);

            if (billetesUsados > 0) {
                cantidad -= billetesUsados * denominacion;

                switch (denominacion) {
                    case 100:
                        billetes100 -= billetesUsados;
                        break;
                    case 200:
                        billetes200 -= billetesUsados;
                        break;
                    case 500:
                        billetes500 -= billetesUsados;
                        break;
                    case 1000:
                        billetes1000 -= billetesUsados;
                        break;
                }
            }

            if (cantidad == 0) {
                return true;
            }
        }

        return false;
    }

    private static void actualizarBilletes() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(BILLETES_FILE))) {
            outputStream.writeInt(billetes100);
            outputStream.writeInt(billetes200);
            outputStream.writeInt(billetes500);
            outputStream.writeInt(billetes1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void guardarLog(String accion, String usuario, double monto, String seRealizo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOGS_FILE, true))) {
            writer.println(accion + ", " + usuario + ", " + monto + ", " + seRealizo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
