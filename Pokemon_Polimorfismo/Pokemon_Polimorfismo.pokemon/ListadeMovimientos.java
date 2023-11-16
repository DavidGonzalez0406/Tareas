import java.util.ArrayList;

public class ListadeMovimientos {
private ArrayList<Movimiento> movimientos = new ArrayList<>();
    
    public ListadeMovimientos(){
        
        movimientos.add(new Movimiento("Destructor", 40, Tipo.NORMAL, 35, TipoAtaque.FISICO));
        movimientos.add(new Movimiento("Poder Pasado", 60, Tipo.ROCA, 5, TipoAtaque.FISICO ));
        movimientos.add(new Movimiento("Esfera Aural", 80, Tipo.LUCHA, 20, TipoAtaque.ESPECIAL ));
        movimientos.add(new Movimiento("Psiquico", 90, Tipo.PSIQUICO, 10, TipoAtaque.ESPECIAL ));
               
        movimientos.add(new Movimiento("Tornado",40, Tipo.VOLADOR, 35,TipoAtaque.ESPECIAL));
        movimientos.add(new Movimiento("Nieve Polvo",40, Tipo.ELECTRICO, 25,TipoAtaque.ESPECIAL));
        movimientos.add(new Movimiento("Esquirla Helada",40, Tipo.ELECTRICO, 30,TipoAtaque.FISICO));
        movimientos.add(new Movimiento("Liofilizacion",70, Tipo.ELECTRICO, 20,TipoAtaque.FISICO));
        }
    
    public Movimiento buscarMovimientoPorNombre(String nombre){
        for (Movimiento movimiento : movimientos){
            if (movimiento.getNombre().equals(nombre)){
                return movimiento;
            }
        }
        return null;
    }
}   
