package algopoly.modelos.tablero.propiedad;

import algopoly.modelos.jugador.Jugador;

public class SinPropietario extends EstadoPropiedad {

	@Override
	public void comprarPropiedad(Jugador jugador, Propiedad propiedad) {
		jugador.comprarPropiedad(propiedad);
		propiedad.setPropietario(jugador);
	}

	@Override
	public void pagarAlquiler(Jugador jugador, Propiedad propiedad) {
	}

	@Override
	public void construirCasa(Propiedad propiedad) {
	}

	@Override
	public void construirHotel(Propiedad propiedad) {
	}

}
