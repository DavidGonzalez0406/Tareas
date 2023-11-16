package Pokemon_Abstraccion;

import Pokemon_Abstraccion.pokemon.PokemonFuego;
import Pokemon_Abstraccion.pokemon.PokemonElectrico;

public class BatallaPokemon {
    public static void main(String[] args){
        PokemonFuego Flareon = new PokemonFuego("Flareon", 10);
        PokemonElectrico Anpharos = new PokemonElectrico("Ampharos", 10);
        
        Flareon.atacar(3, Anpharos);
        Anpharos.atacar(2, Flareon);
    
        System.out.println(Flareon.getNombre() + ": HP " + Flareon.getHP());
        System.out.println(Anpharos.getNombre() + ": HP " + Anpharos.getHP());
    }
}
