package pokemon.pokemon;

public class Mew extends Pokemon {
    public Mew(Tipo tipo, int PS, int Ataque, int Defensa, int AtaqueEspecial, int DefensaEspecial, int Velocidad, int Nivel) {
        super(Tipo.PSIQUICO, 100, 100, 100, 100, 100, 100, 10);
        
        ListaMovimientos listaMovimientos = new ListaMovimientos();
        
        Movimiento[] movimientos = new Movimiento[4];
        movimientos[0] = listaMovimientos.buscarMovimientoPorNombre("Destructor");
        movimientos[1] = listaMovimientos.buscarMovimientoPorNombre("Poder Pasado");
        movimientos[2] = listaMovimientos.buscarMovimientoPorNombre("Esfera Aural");
        movimientos[3] = listaMovimientos.buscarMovimientoPorNombre("Psiquico");
        
        setMovimientos(movimientos);
    }

    @Override
    public double obtenerEfectividad(Pokemon pokemon) {
        double efectividad = 1.0;
        
        //No efectivo
        if (pokemon.getTipo() == Tipo.BICHO) efectividad = 0.50;
        if (pokemon.getTipo() == Tipo.FANTASMA) efectividad = 0.50;
        if (pokemon.getTipo() == Tipo.SINIESTRO) efectividad = 0.50;
         
        //Efectivo
        if (pokemon.getTipo() == Tipo.LUCHA) efectividad = 2.0;
        if (pokemon.getTipo() == Tipo.PSIQUICO) efectividad = 2.0;
        
        return efectividad;   
    }   
}
