package algopoly.modelos.tablero.casilleros;

import algopoly.modelos.jugador.Jugador;

public class Salida implements Casillero {

    private static final String NOMBRE = "SALIDA";

    @Override
    public String getNombre(){
        return NOMBRE;
    }

    @Override
    public void recibirJugador(Jugador jugador){

    }
}
