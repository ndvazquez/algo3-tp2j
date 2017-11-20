package algopoly.modelos.tablero.propiedad;

import algopoly.modelos.jugador.Jugador;

public class RegionCompleta implements EstadoPropiedad {
	
	private Propiedad propiedad;
	
	public RegionCompleta(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	@Override
	public void comprarPropiedad(Jugador jugador) {
	}

	@Override
	public void pagarAlquiler(Jugador jugador) {
		if ( ! this.propiedad.getPropietario().esEsteJugador(jugador) )
			jugador.pagarAlquiler(this.propiedad.getPropietario(), this.propiedad);
	}

	@Override
	public void construirCasa() {
		Edificio edificio = this.propiedad.getProvincia().edificios().get(this.propiedad.cantidadEdificios() + 1);
		
		if ( this.propiedad.getPropietario().getCapital() - edificio.getPrecio() >= 0 ) {
			this.propiedad.getPropietario().incrementarCapital( -edificio.getPrecio() );
			this.propiedad.construir(edificio);
		}
	}


	@Override
	public void contruirHotel() {
		Edificio edificio = this.propiedad.getProvincia().hotel();
		if ( this.propiedad.getPropietario().getCapital() - edificio.getPrecio() >= 0 ) {
			this.propiedad.getPropietario().incrementarCapital( -edificio.getPrecio() );
			this.propiedad.construir(edificio);
		}
	}

}