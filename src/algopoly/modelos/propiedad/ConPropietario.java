package algopoly.modelos.propiedad;

import algopoly.modelos.jugador.Jugador;

public class ConPropietario implements EstadoPropiedad {

	private Propiedad propiedad;

	public ConPropietario(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	@Override
	public void comprarPropiedad(Jugador jugador) {
	}

	@Override
	public void pagarAlquiler(Jugador jugador) {
		if ( this.propiedad.getPropietario() != jugador)
			jugador.pagarAlquiler(this.propiedad.getPropietario(), this.propiedad);
	}
}