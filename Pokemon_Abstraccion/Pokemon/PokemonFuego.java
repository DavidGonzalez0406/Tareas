import Pokemon_Abstraccion.pokemon.ListaMovimientos;
import Pokemon_Abstraccion.pokemon.Movimiento;
import Pokemon_Abstraccion.pokemon.Pokemon;
import Pokemon_Abstraccion.pokemon.Tipo;

public class PokemonFuego extends Pokemon {
    public PokemonFuego(String nombre, int nivel) {
        super(nombre, Tipo.FUEGO, nivel);

        ListaMovimientos listaMovimientos = new ListaMovimientos();

        Movimiento[] movimientos = new Movimiento[4];
        movimientos[0] = listaMovimientos.buscarMovimientoPorNombre("Ascuas");
        movimientos[1] = listaMovimientos.buscarMovimientoPorNombre("Colmillo igneo");
        movimientos[2] = listaMovimientos.buscarMovimientoPorNombre("Giro Fuego");
        movimientos[3] = listaMovimientos.buscarMovimientoPorNombre("Evite igneo");

        setMovimientos(movimientos);
    }

    @Override
    public double obtenerEfectividad(Pokemon pokemon) {
        double efectividad = 1.0;

        //No efectivo
        if (pokemon.getTipo() == Tipo.AGUA || 
            pokemon.getTipo() == Tipo.ROCA || 
            pokemon.getTipo() == Tipo.FUEGO || 
            pokemon.getTipo() == Tipo.DRAGON) {
            efectividad = 0.0;
        }

        //Efectivo
        if (pokemon.getTipo() == Tipo.BICHO || 
            pokemon.getTipo() == Tipo.PLANTA || 
            pokemon.getTipo() == Tipo.ACERO || 
            pokemon.getTipo() == Tipo.HIELO) {
            efectividad = 2.0;
        }

        return efectividad;        
    }
}
