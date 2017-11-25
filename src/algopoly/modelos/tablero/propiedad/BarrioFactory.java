package algopoly.modelos.tablero.propiedad;

public class BarrioFactory {

    public BarrioSimple crearBarrioSimple(Provincia provincia){
        return new BarrioSimple(provincia);
    }

    public BarrioDoble crearBarrioDoble(Provincia provincia, Provincia provinciaComplemento){
        return new BarrioDoble(provincia, provinciaComplemento);
    }

}
