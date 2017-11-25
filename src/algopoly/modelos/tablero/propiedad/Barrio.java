package algopoly.modelos.tablero.propiedad;

import algopoly.modelos.jugador.Jugador;

public interface Barrio {
	
	Jugador getPropietario();
	
	Integer getPrecio();

	Integer getPrecioAlquiler();

	void setPropietario(Jugador jugador);

	boolean esEstaProvincia(Provincia provincia);

	Integer cantidadEdificios();

	Provincia getProvincia();

	void construir(Inmueble inmueble);

	void construirCasa();

	void construirHotel();

	void resetBarrio();
}
