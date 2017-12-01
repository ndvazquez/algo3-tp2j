package algopoly.modelos.tablero.casilleros.compania;

import algopoly.modelos.jugador.Jugador;

public interface Estado {

	void recibirJugador(Jugador jugador, Compania compania);

	void comprarCompania(Jugador jugador, Compania compania);
}
