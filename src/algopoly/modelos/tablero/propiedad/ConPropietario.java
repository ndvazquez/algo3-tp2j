package algopoly.modelos.tablero.propiedad;

import algopoly.modelos.jugador.Jugador;

public class ConPropietario extends EstadoPropiedad {

	@Override
	public void comprarPropiedad(Jugador jugador, Propiedad propiedad) {
	}

	@Override
	public void construirCasa(Propiedad propiedad) {
	}

	@Override
	public void construirHotel(Propiedad propiedad) {
	}

	@Override
	void vender(Propiedad propiedad) {
		Jugador propietario = propiedad.getPropietario();
		propietario.quitarPropiedad(propiedad);
		
		propiedad.reset();
		
	}
}