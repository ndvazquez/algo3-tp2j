package algopoly.modelos.propiedad;

import algopoly.modelos.jugador.Jugador;

public interface Propiedad {
	
	Jugador getPropietario();
	
	Integer getPrecio();

	Integer getPrecioCasa();

	Integer getPrecioAlquiler();

	void construir();
}
