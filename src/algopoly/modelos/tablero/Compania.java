package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

public class Compania implements Casillero {

	private Integer precio;
	private Jugador propietario;
	private Integer impuesto;
	private Integer impuestoDoble;
	private Servicios servicios;

	public Compania(Integer precio, Integer impuesto, Integer impuestoDoble, Servicios servicios) {
		this.precio = precio;
		this.impuesto = impuesto;
		this.impuestoDoble = impuestoDoble;
		this.servicios = servicios;
		this.servicios.agregarCompania(this);
	}

	@Override
	public void recibirJugador(Jugador jugador) {
		if (this.propietario == null) {
			jugador.comprarCompania(this);
			jugador.incrementarCapital(-precio);
			this.propietario = jugador;
		} else {
			this.servicios.cobrarImpuesto(this, jugador);
		}
	}

	public boolean soyTuDueño(Jugador jugador) {
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

}
