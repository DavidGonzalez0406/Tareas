public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public int getPp() {
        return pp;
    }

    public Tipo getTipo() {
        return tipo;
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
