import Pokemon_Abstraccion.pokemon.ListaMovimientos;
import Pokemon_Abstraccion.pokemon.Movimiento;
import Pokemon_Abstraccion.pokemon.Pokemon;
import Pokemon_Abstraccion.pokemon.Tipo;

public class PokemonElectrico extends Pokemon {
    public PokemonElectrico(String nombre, int nivel) {
        super(nombre, Tipo.ELECTRICO, nivel);
        
        ListaMovimientos listaMovimientos = new ListaMovimientos();
        
        Movimiento[] movimientos = new Movimiento[4];
        movimientos[0] = listaMovimientos.buscarMovimientoPorNombre("Puño Trueno");
        movimientos[1] = listaMovimientos.buscarMovimientoPorNombre("Impactrueno");
        movimientos[2] = listaMovimientos.buscarMovimientoPorNombre("Electrocañon");
        movimientos[3] = listaMovimientos.buscarMovimientoPorNombre("Chispazo");
        
        setMovimientos(movimientos);
    }

    @Override
    public double obtenerEfectividad(Pokemon pokemon) {
        double efectividad = 1.0;
        
        //No efectivo
        if (pokemon.getTipo() == Tipo.PLANTA) efectividad = 0.0;
        if (pokemon.getTipo() == Tipo.ELECTRICO) efectividad = 0.0;
        if (pokemon.getTipo() == Tipo.DRAGON) efectividad = 0.0;
         
        //Efectivo
        if (pokemon.getTipo() == Tipo.AGUA) efectividad = 2.0;
        if (pokemon.getTipo() == Tipo.VOLADOR) efectividad = 2.0;
        
        return efectividad;   
    }   
}
