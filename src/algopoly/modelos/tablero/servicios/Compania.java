package algopoly.modelos.tablero.servicios;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Casillero;

public class Compania implements Casillero {

	private Integer precio;
	private Jugador propietario;
	private Integer impuesto;
	private Integer impuestoDoble;
	private Servicios servicios;
	private Estado estado;

	public Compania(Integer precio, Integer impuesto, Integer impuestoDoble, Servicios servicios) {
		this.precio = precio;
		this.impuesto = impuesto;
		this.impuestoDoble = impuestoDoble;
		this.servicios = servicios;
		this.servicios.agregarCompania(this);
		this.estado = new SinPropietario();
	}

	@Override
	public void recibirJugador(Jugador jugador) {
		this.estado.recibirJugador(jugador, this);
	}

	public boolean soyTuDuenio(Jugador jugador) {
		return jugador.equals(this.propietario);
	}

	public Jugador getPropietario() {
		return this.propietario;
	}

	public Integer getImpuesto() {
		return this.impuesto;
	}

	public Integer getImpuestoDoble() {
		return this.impuestoDoble;
	}

	public Servicios getServicios() {
		return this.servicios;
	}

	public void setPropietario(Jugador jugador) {
		this.propietario = jugador;
		this.estado = new ConPropietario();
	}

	public Integer getPrecio() {
		return this.precio;
	}

}
