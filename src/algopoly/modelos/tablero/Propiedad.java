package algopoly.modelos.tablero;

import algopoly.modelos.excepciones.PropiedadSinJugadorError;
import algopoly.modelos.jugador.Jugador;

public interface Propiedad {
	
	Jugador getPropietario() throws PropiedadSinJugadorError;
	
	Integer getPrecio();

	Integer getPrecioCasa();
	
	Integer getPrecioHotel();

	void construir();

	Integer getPrecioAlquiler();

}