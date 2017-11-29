package algopoly.modelos.tablero.casilleros.barrios;

import algopoly.modelos.jugador.Jugador;

public class Hotel implements Inmueble {
	
	private Integer alquiler;
	private Integer precio;
	
	public Hotel(Integer precio, Integer alquiler) {
		this.alquiler = alquiler;
		this.precio = precio;
	}

	@Override
	public Integer getPrecio() {
		return this.precio;
	}

	@Override
	public void cobrarAlquiler(Jugador propietario, Jugador jugador) {
		jugador.pagar(this.alquiler);
		propietario.cobrar(this.alquiler);
	}
}
