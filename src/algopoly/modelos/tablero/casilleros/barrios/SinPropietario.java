package algopoly.modelos.tablero.casilleros.barrios;

import algopoly.modelos.jugador.Jugador;

public class SinPropietario extends EstadoBarrio {

	@Override
	public void comprarBarrio(Jugador jugador, Barrio barrio) {
		jugador.comprarBarrio(barrio);
		barrio.setPropietario(jugador);
	}

	@Override
	public void pagarAlquiler(Jugador jugador, Barrio barrio) {
	}

	@Override
	public void construirCasa(Barrio barrio) {
	}

	@Override
	public void construirHotel(Barrio barrio) {
	}

}
