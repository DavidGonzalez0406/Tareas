import cajeroautomáticomain.Administrador;
import java.util.Scanner;

public class CajeroAutomáticoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su NIP de 4 dígitos: ");
        int nip = scanner.nextInt();

        if (nombre.equalsIgnoreCase("admin") && nip == 3243) {
            Administrador.mostrarLogs();
            Administrador.mostrarCantidadBilletes();
        } else {
            Usuario usuario = new Usuario(nombre, nip);
            Cajero.inicializarBilletes();

            Cajero.realizarAccionCajero(usuario);
        }
    }
}
