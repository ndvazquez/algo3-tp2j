package algopoly.modelos.tablero.casilleros.barrios;

import algopoly.modelos.jugador.Jugador;

public interface Barrio {
	String getNombre();

	Jugador getPropietario();
	
	Integer getPrecio();

	Integer getPrecioDeVenta();

	void setSinPropietario();

	void setPropietario(Jugador jugador);

	boolean esEstaProvincia(Provincia provincia);

	Integer cantidadEdificios();

	Provincia getProvincia();

	void construir(Inmueble inmueble);

	boolean construirCasa();

	boolean construirHotel();

	void resetBarrio();

	Inmueble getInmuebleActual();
}
