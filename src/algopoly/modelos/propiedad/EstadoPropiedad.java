package algopoly.modelos.propiedad;

import algopoly.modelos.jugador.Jugador;

public interface EstadoPropiedad {

	void comprarPropiedad(Jugador jugador);

	void pagarAlquiler(Jugador jugador);
}