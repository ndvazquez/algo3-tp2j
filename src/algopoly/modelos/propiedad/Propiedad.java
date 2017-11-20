package algopoly.modelos.propiedad;

import algopoly.modelos.jugador.Jugador;

public interface Propiedad {
	
	Jugador getPropietario();
	
	Integer getPrecio();

	Integer getPrecioAlquiler();

	void setPropietario(Jugador jugador);

	boolean esEstaProvincia(Provincia provincia);

	Integer cantidadEdificios();

	Provincia getProvincia();

	void construir(Edificio edificio);

	void construirCasa();

	void construirHotel();
}
