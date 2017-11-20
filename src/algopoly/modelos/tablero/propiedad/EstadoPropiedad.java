package algopoly.modelos.tablero.propiedad;

import algopoly.modelos.jugador.Jugador;

public interface EstadoPropiedad {

	void comprarPropiedad(Jugador jugador);

	void pagarAlquiler(Jugador jugador);

	void construirCasa();
	
	void contruirHotel();
}