package modelos;

import java.util.HashMap;

public class Quini6 {
    /* Diccionario de jugadores, se utiliza para contar las visitas a la casilla */
    private HashMap<Jugador, Integer> jugadoresRecibidos = new HashMap<>();

    public void recibirJugador(Jugador jugador){
        /* Si el jugador ya visitó la casilla se suma 1 a las visitas, en caso contrario se inicializan en 1 */
        jugadoresRecibidos.put(
                jugador, jugadoresRecibidos.containsKey(jugador) ? jugadoresRecibidos.get(jugador) + 1 : 1
        );

        if (jugadoresRecibidos.get(jugador) == 1) {jugador.incrementarCapital(50000);}

        else if(jugadoresRecibidos.get(jugador) == 2) {jugador.incrementarCapital(30000);}
    }
}
