package algopoly.modelos.tablero.barrios;

import algopoly.modelos.jugador.Jugador;

public interface Barrio {
	
	Jugador getPropietario();
	
	Integer getPrecio();

	Integer getPrecioAlquiler();

	Integer getPrecioDeVenta();

	void setSinPropietario();

	void setPropietario(Jugador jugador);

	boolean esEstaProvincia(Provincia provincia);

	Integer cantidadEdificios();

	Provincia getProvincia();

	void construir(Inmueble inmueble);

	void construirCasa();

	void construirHotel();

	void resetBarrio();
}
