package algopoly.modelos.propiedad;

import algopoly.modelos.jugador.Jugador;

public interface Propiedad {
	
	Jugador getPropietario();
	
	Integer getPrecio();

	Integer getPrecioEdificio();

	Integer getPrecioAlquiler();

	void construir();

	void setPropietario(Jugador jugador);
}
