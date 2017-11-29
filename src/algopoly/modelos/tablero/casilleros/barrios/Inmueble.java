package algopoly.modelos.tablero.casilleros.barrios;

import algopoly.modelos.jugador.Jugador;

public interface Inmueble {

	Integer getPrecio();

	void cobrarAlquiler(Jugador propietario, Jugador jugador);

}
