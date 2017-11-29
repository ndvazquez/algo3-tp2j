package algopoly.modelos.tablero.casilleros;

import algopoly.modelos.jugador.Jugador;

public interface Casillero {

	String getNombre();

	void recibirJugador(Jugador jugador);
}
