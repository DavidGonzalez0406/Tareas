package Pokemon_Polimorfismo.pokemon;

public class Movimiento {
    private String nombre;
    private int puntosDeAtaque;
    private int pp;
    private Tipo tipo;
    private TipoAtaque TipoAtaque;

    Movimiento(String nombre, int puntosDeAtaque, Tipo tipo, int pp, TipoAtaque TipoAtaque) {
        this.nombre = nombre;
        this.puntosDeAtaque = puntosDeAtaque;
        this.pp = pp;
        this.tipo = tipo;
        this.TipoAtaque = TipoAtaque;
        this.movimientos = movimientos;
    }
    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public int getPp() {
        return pp;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public TipoAtaque getTipoAtaque() {
        return TipoAtaque;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

private Movimiento movimientos[];

public void setMovimiento(int indice, Movimiento movimiento) {
    movimientos[indice] = movimiento;
}

public Movimiento getMovimiento(int indice) {
    return movimientos[indice];
}

}  
