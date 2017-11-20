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
		// constructor descartado
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
		this.estado = new RegionCompleta(this);
		this.edificio = this.provincia.vacio();
	}
	
	@Override
	public Integer getPrecio(){
		return this.provincia.precio();
	}

	@Override
	public Integer getPrecioAlquiler() {
		return edificio.getAlquiler();
	}
	
	@Override
	public void construir(Edificio edificio) {
    	this.edificio = edificio;
		this.cantidadEdificios += 1;
    }
	
	public void construirCasa() {
		if (this.cantidadEdificios < 1) {
			this.estado.construirCasa();
		}
	}

	@Override
	public boolean esEstaProvincia(Provincia estaOtraProvincia) {
		return this.provincia == estaOtraProvincia;
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
}