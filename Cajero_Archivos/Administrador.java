import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Administrador {

    public static void mostrarLogs() {
        System.out.println("Listado de acciones guardadas en el log:");
        try (BufferedReader reader = new BufferedReader(new FileReader("logs.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarCantidadBilletes() {
        System.out.println("Cantidad de billetes restantes:");
        System.out.println("Billetes de $100: " + Cajero.getBilletes100());
        System.out.println("Billetes de $200: " + Cajero.getBilletes200());
        System.out.println("Billetes de $500: " + Cajero.getBilletes500());
        System.out.println("Billetes de $1000: " + Cajero.getBilletes1000());
    }
}
