package algopoly.modelos.tablero.propiedad;

import algopoly.modelos.jugador.Jugador;

public abstract class EstadoPropiedad {

	abstract void comprarPropiedad(Jugador jugador, Propiedad propiedad);

	void pagarAlquiler(Jugador jugador, Propiedad propiedad) {
		if (!propiedad.getPropietario().esEsteJugador(jugador)) {
			int monto = propiedad.getPrecioAlquiler();
			if (jugador.getCapital() - monto >= 0) {
				jugador.incrementarCapital(-monto);
				propiedad.getPropietario().incrementarCapital(monto);
			}
		}
	}


	abstract void construirCasa(Propiedad propiedad);
	
	abstract void construirHotel(Propiedad propiedad);

}