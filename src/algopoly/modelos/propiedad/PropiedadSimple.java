package algopoly.modelos.propiedad;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Casillero;

public class PropiedadSimple implements Casillero, Propiedad {

	private Jugador propietario;

	private EstadoPropiedad estado;

	private Integer cantidadEdificios;

	private Edificio edificio;

	private Provincia provincia;

	public PropiedadSimple(Provincia provincia) {
		this.provincia = provincia;
		this.estado = new SinPropietario(this);
		this.cantidadEdificios = 0;
	}

	public PropiedadSimple(Integer precio, Integer precioCasa){
	}

	@Override
	public void recibirJugador(Jugador jugador) {

		this.estado.comprarPropiedad(jugador);

		this.estado.pagarAlquiler(jugador);
	}

	@Override
	public Jugador getPropietario() {
		return this.propietario;
	}

	@Override
	public void setPropietario(Jugador jugador) {
		this.propietario = jugador;
		this.estado = new ConPropietario(this);
		this.edificio = this.provincia.vacio();
	}
	
	@Override
	public Integer getPrecio(){
		return this.provincia.precio();
	}

	@Override
	public Integer getPrecioEdificio() {
		return edificio.getPrecio();
	}

	@Override
	public Integer getPrecioAlquiler() {
		return edificio.getAlquiler();
	}

	public void construir() {

		if (this.cantidadEdificios < 1) {

			Edificio edificio = this.provincia.unaCasa();
			if ( this.propietario.comprar(edificio.getPrecio()) ) {
				this.cantidadEdificios += 1;
				this.edificio = edificio;
			}
		}
	}
}