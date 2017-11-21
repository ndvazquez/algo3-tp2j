package algopoly.modelos.tablero.propiedad;

import algopoly.modelos.jugador.Jugador;

public class SinPropietario implements EstadoPropiedad {

	private Propiedad propiedad;

	public SinPropietario(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	@Override
	public void comprarPropiedad(Jugador jugador) {
		jugador.comprarPropiedad(this.propiedad);
		this.propiedad.setPropietario(jugador);
	}

	@Override
	public void pagarAlquiler(Jugador jugador) {
	}

	@Override
	public void construirCasa() {
	}

	@Override
	public void construirHotel() {
	}
}
