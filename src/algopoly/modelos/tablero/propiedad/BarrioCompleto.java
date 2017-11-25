package algopoly.modelos.tablero.propiedad;

import algopoly.modelos.jugador.Jugador;

public class BarrioCompleto extends EstadoBarrio {

	@Override
	public void comprarBarrio(Jugador jugador, Barrio barrio) {
	}

	@Override
	public void construirCasa(Barrio barrio) {
		Inmueble edificio = barrio.getProvincia().edificios().get(barrio.cantidadEdificios() + 1);
		
		barrio.getPropietario().pagar(edificio.getPrecio() );
		barrio.construir(edificio);
	}
    
	@Override
	public void construirHotel(Barrio barrio) {
		Inmueble edificio = barrio.getProvincia().hotel();
		barrio.getPropietario().pagar(edificio.getPrecio() );
		barrio.construir(edificio);
	}

}