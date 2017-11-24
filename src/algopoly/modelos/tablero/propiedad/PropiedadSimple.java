package algopoly.modelos.tablero.propiedad;

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
		this.estado = new SinPropietario();
		this.cantidadEdificios = 0;
	}

	@Override
	public void recibirJugador(Jugador jugador) {

		this.estado.comprarPropiedad(jugador, this);

		this.estado.pagarAlquiler(jugador, this);
	}

	@Override
	public Jugador getPropietario() {
		return this.propietario;
	}

	@Override
	public void setPropietario(Jugador jugador) {
		this.propietario = jugador;
		this.estado = new RegionCompleta();
		this.edificio = this.provincia.vacio();
	}
	
	@Override
	public Integer getPrecio(){
		return this.provincia.precio();
	}

	@Override
	public Integer getPrecioAlquiler() {
		return this.edificio.getAlquiler();
	}

	@Override
	public Integer getPrecioDeVenta(){
		return (this.edificio.getPrecio() + this.getPrecio());
	}
	@Override
	public void construir(Edificio edificio) {
    	this.edificio = edificio;
		this.cantidadEdificios += 1;
    }
	
	@Override
	public void construirCasa() {
		if (this.cantidadEdificios < 1) {
			this.estado.construirCasa(this);
		}
	}

	@Override
	public boolean esEstaProvincia(Provincia estaProvincia) {
		return this.provincia.name().equals(estaProvincia.name());
	}

	@Override
	public Integer cantidadEdificios() {
		return this.cantidadEdificios;
	}

	@Override
	public Provincia getProvincia() {
		return this.provincia;
	}

	@Override
	public void construirHotel() {
	}

	@Override
	public void resetPropiedades() {
		this.cantidadEdificios = 0;
		this.edificio = this.provincia.vacio();
	}
}