import Pokemon_Polimorfismo.pokemon.Mew;
import Pokemon_Polimorfismo.pokemon.Articuno;
import Pokemon_Polimorfismo.pokemon.Tipo;

public class BatallaPokemon {
public static void main(String[] args) {
      Mew mewInstancia = new Mew(Tipo.PSIQUICO, 100, 100, 100, 100, 100, 100, 10);
      Articuno articunoInstancia = new Articuno(Tipo.HIELO.VOLADOR, 90, 85, 100, 95, 125, 85, 10);
   
  mewInstancia.atacar(2, articunoInstancia);
  articunoInstancia.atacar(1, mewInstancia);

  System.out.println(Mew.class.getSimpleName() + ": PS " + mewInstancia.getPS());
  System.out.println(Articuno.class.getSimpleName() + ": PS " + articunoInstancia.getPS());
    }
}
