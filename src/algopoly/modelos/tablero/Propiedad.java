package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

public interface Propiedad {
	
	Jugador getPropietario();
	
	Integer getPrecio();

	Integer getPrecioCasa();
	
	Integer getPrecioHotel();

	void construir();

	Integer getPrecioAlquiler();

}
