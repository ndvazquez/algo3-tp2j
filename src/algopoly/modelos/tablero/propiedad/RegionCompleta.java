package algopoly.modelos.tablero.propiedad;

import algopoly.modelos.jugador.Jugador;

public class RegionCompleta extends EstadoPropiedad {

	@Override
	public void comprarPropiedad(Jugador jugador, Propiedad propiedad) {
	}

	@Override
	public void construirCasa(Propiedad propiedad) {
		Edificio edificio = propiedad.getProvincia().edificios().get(propiedad.cantidadEdificios() + 1);
		
		if ( propiedad.getPropietario().getCapital() - edificio.getPrecio() >= 0 ) {
			propiedad.getPropietario().incrementarCapital( -edificio.getPrecio() );
			propiedad.construir(edificio);
		}
	}
    
	@Override
	public void construirHotel(Propiedad propiedad) {
		Edificio edificio = propiedad.getProvincia().hotel();
		if ( propiedad.getPropietario().getCapital() - edificio.getPrecio() >= 0 ) {
			propiedad.getPropietario().incrementarCapital( -edificio.getPrecio() );
			propiedad.construir(edificio);
		}
	}

}