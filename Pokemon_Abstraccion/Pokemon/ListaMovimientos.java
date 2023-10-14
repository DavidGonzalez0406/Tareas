package pokemon.pokemon;
import java.util.ArrayList;

public class ListaMovimientos {
private ArrayList<Movimiento> movimientos = new ArrayList<>();
    
    public ListaMovimientos(){
        //Movimiento de tipo fuego
        movimientos.add(new Movimiento("Ascuas", 40, Tipo.FUEGO, 25));
        movimientos.add(new Movimiento("Colmillo igneo", 65, Tipo.FUEGO, 15 ));
        movimientos.add(new Movimiento("Giro Fuego", 35, Tipo.FUEGO, 15 ));
        movimientos.add(new Movimiento("Evite igneo", 120, Tipo.FUEGO, 15 ));
               
        //Movimiento de tipo electrico
        movimientos.add(new Movimiento("Puño Trueno",75, Tipo.ELECTRICO, 15));
        movimientos.add(new Movimiento("Impactrueno",40, Tipo.ELECTRICO, 30));
        movimientos.add(new Movimiento("Electrocañon",120, Tipo.ELECTRICO, 5));
        movimientos.add(new Movimiento("Chispazo",80, Tipo.ELECTRICO, 15));
        }
    
    // Metodo que devuelve el movimiento buscando el nombre
    public Movimiento buscarMovimientoPorNombre(String nombre){
        for (Movimiento movimiento : movimientos){
            if (movimiento.getNombre().equals(nombre)){
                return movimiento;
            }
        }
        return null;
    }
} 
