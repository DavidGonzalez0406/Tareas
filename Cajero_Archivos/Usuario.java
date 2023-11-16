import java.util.Random;

class Usuario {
    private String nombre;
    private int nip;
    private double saldo;

    public Usuario(String nombre, int nip) {
        this.nombre = nombre;
        this.nip = nip;
        this.saldo = new Random().nextInt(49000) + 1000; 
    }

    public String getNombre() {
        return nombre;
    }

    public int getNip() {
        return nip;
    }

    public double getSaldo() {
        return saldo;
    }

    public void actualizarSaldo(double monto) {
        saldo -= monto;
    }
}
