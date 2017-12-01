package algopoly.modelos.tablero.casilleros.barrios;

import algopoly.modelos.jugador.Jugador;

public class SinInmueble implements Inmueble{

	@Override
	public Integer getPrecio() {
		return null;
	}

	@Override
	public void cobrarAlquiler(Jugador propietario, Jugador jugador) {
	}

}
