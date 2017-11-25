package algopoly.modelos.tablero.propiedad;

import algopoly.modelos.jugador.Jugador;

public abstract class EstadoBarrio {

	abstract void comprarBarrio(Jugador jugador, Barrio barrio);

	void pagarAlquiler(Jugador jugador, Barrio barrio) {
		if (! barrio.getPropietario().equals(jugador)) {
			int monto = barrio.getPrecioAlquiler();
			jugador.pagar(monto);
			barrio.getPropietario().cobrar(monto);
		}
	}


	abstract void construirCasa(Barrio barrio);
	
	abstract void construirHotel(Barrio barrio);

}