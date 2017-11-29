package algopoly.modelos.tablero.casilleros.barrios;

import algopoly.modelos.jugador.Jugador;

public class Vacio implements Inmueble {
	
	private Integer precio;
	
	private Integer alquiler;
	
	public Vacio(Integer precio, Integer alquiler) {
		this.precio = precio;
		this.alquiler = alquiler;
	}
	
	@Override
	public Integer getPrecio() {
		return this.precio;
	}

	@Override
	public void cobrarAlquiler(Jugador propietario, Jugador jugador) {
		jugador.pagar(this.alquiler);
		propietario.cobrar(this.alquiler);
		jugador.setMensajes(String.format("\t%s pagó %d a %s.\n", jugador.getNombre(), this.alquiler,
				propietario.getNombre()));
	}

}