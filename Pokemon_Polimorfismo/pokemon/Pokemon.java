package pokemon.pokemon;

public abstract class Pokemon {

    private Tipo tipo;
    private int PS;
    private int Ataque;
    private int Defensa;
    private int AtaqueEspecial;
    private int DefensaEspecial;
    private int Velocidad;
    private int Nivel;
    private Movimiento movimientos[];

    public Pokemon(Tipo tipo, int PS, int Ataque, int Defensa, int AtaqueEspecial, int DefensaEspecial, int Velocidad, int Nivel) {
        this.tipo = tipo;
        this.PS = PS;
        this.Ataque = Ataque;
        this.Defensa = Defensa;
        this.AtaqueEspecial = AtaqueEspecial;
        this.DefensaEspecial = DefensaEspecial;
        this.Velocidad = Velocidad;
        this.Nivel = Nivel;
    }
 public Tipo getTipo() {
        return tipo;
    }

    public int getPS() {
        return PS;
    }

    public int getAtaque() {
        return Ataque;
    }

    public int getDefensa() {
        return Defensa;
    }

    public int getAtaqueEspecial() {
        return AtaqueEspecial;
    }

    public int getDefensaEspecial() {
        return DefensaEspecial;
    }

    public int getVelocidad() {
        return Velocidad;
    }

    public int getNivel() {
        return Nivel;
    }

    public Movimiento[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Movimiento[] movimientos) {
        this.movimientos = movimientos;
    }

    protected void calculaDanio(int danio, double efectividad) {
        double puntosRestados = danio * efectividad;
        this.PS -= puntosRestados;
        System.out.printf("%s recibe %.2f puntos de daño\n", this.getClass().getSimpleName(), puntosRestados);
    }

    public void recibirAtaques(Movimiento movimiento, double efectividad) {
        System.out.printf("%s recibe ATK %s\n", this.getClass().getSimpleName(), movimiento.getNombre());
        calculaDanio(movimiento.getPuntosDeAtaque(), efectividad);
    }

    protected boolean seHaConcretadoAtaque(Movimiento movimiento, Pokemon pokemon) {
        System.out.printf("%s ataca %s con %s\n", this.getClass().getSimpleName(), pokemon.getClass().getSimpleName(), movimiento.getNombre());
        double efectividad = obtenerEfectividad(pokemon);

        if (movimiento.getPp() > 0) {
            pokemon.recibirAtaques(movimiento, efectividad);
            return true;
        } else {
            System.err.println("El movimiento no tiene puntos de PP");
            return false;
        }
    }

    public void atacar(int m, Pokemon pokemon) {
        Movimiento movimiento = getMovimientos()[m];
        boolean seHaConcretadoAtaque = seHaConcretadoAtaque(movimiento, pokemon);
        if (seHaConcretadoAtaque) {
            movimiento.setPp(movimiento.getPp() - 1);
        }
    }

    public abstract double obtenerEfectividad(Pokemon pokemon);
}
