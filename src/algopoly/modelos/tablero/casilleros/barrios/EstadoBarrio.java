package algopoly.modelos.tablero.casilleros.barrios;

import algopoly.modelos.jugador.Jugador;

public abstract class EstadoBarrio {

	abstract void comprarBarrio(Jugador jugador, Barrio barrio);

	void pagarAlquiler(Jugador jugador, Barrio barrio) {
		if (!barrio.getPropietario().equals(jugador)) {
			barrio.getInmuebleActual().cobrarAlquiler(barrio.getPropietario(), jugador);
		}
	}

	abstract void construirCasa(Barrio barrio);
	
	abstract void construirHotel(Barrio barrio);

}