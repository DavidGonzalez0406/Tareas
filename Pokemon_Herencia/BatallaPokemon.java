public class BatallaPokemon {
    public static void main(String[] args){
        PokemonFuego Flareon = new PokemonFuego("Flareon", 10);
        PokemonElectrico Anpharos = new PokemonElectrico("Anpharos", 10);
        
        Flareon.atacar("Ascuas", Anpharos);
        Anpharos.atacar("Electrocacañon", Flareon);
    
        System.out.println(Flareon.getNombre() + ": HP " + Flareon.getHP());
        System.out.println(Anpharos.getNombre() + ": HP " + Anpharos.getHP());
    }
}
