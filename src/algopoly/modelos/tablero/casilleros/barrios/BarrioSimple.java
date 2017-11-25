package algopoly.modelos.tablero.casilleros.barrios;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.casilleros.Casillero;

public class BarrioSimple implements Casillero, Barrio {

	private Jugador propietario;

	private EstadoBarrio estado;

	private Integer cantidadEdificios;

	private Inmueble edificio;

	private Provincia provincia;

	public BarrioSimple(Provincia provincia) {
		this.provincia = provincia;
		this.estado = new SinPropietario();
		this.cantidadEdificios = 0;
	}

	@Override
	public void recibirJugador(Jugador jugador) {

		this.estado.comprarBarrio(jugador, this);

		this.estado.pagarAlquiler(jugador, this);
	}

	@Override
	public Jugador getPropietario() {
		return this.propietario;
	}

	@Override
	public void setSinPropietario(){
		this.propietario = null;
		this.estado = new SinPropietario();
		this.edificio = this.provincia.vacio();
		this.cantidadEdificios = 0;
	}

	@Override
	public void setPropietario(Jugador jugador) {
		this.propietario = jugador;
		this.estado = new BarrioCompleto();
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
	public void construir(Inmueble edificio) {
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
	public void resetBarrio() {
		this.cantidadEdificios = 0;
		this.edificio = this.provincia.vacio();
	}
}