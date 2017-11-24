package algopoly.modelos.tablero.propiedad;

import algopoly.modelos.jugador.Jugador;

public interface Propiedad {
	
	Jugador getPropietario();
	
	Integer getPrecio();

	Integer getPrecioAlquiler();

	Integer getPrecioDeVenta();

	void setPropietario(Jugador jugador);

	boolean esEstaProvincia(Provincia provincia);

	Integer cantidadEdificios();

	Provincia getProvincia();

	void construir(Edificio edificio);

	void construirCasa();

	void construirHotel();

	void resetPropiedades();
}
