package algopoly.modelos.jugador;

import algopoly.modelos.excepciones.JugadorSinPlataException;
import algopoly.modelos.tablero.Carcel;
import algopoly.modelos.tablero.Casillero;
import algopoly.modelos.tablero.Propiedad;

import java.util.ArrayList;

public class Jugador {

	private Dado dado1;

	private Dado dado2;

	private Posicion posicion;

	private ArrayList<Propiedad> propiedades;

	private Integer capital;

	private Estado estado;

	public Jugador() {
		this.capital = 100000;
		this.posicion = Posicion.SALIDA;
		this.dado1 = new Dado();
		this.dado2 = new Dado();
		this.estado = new Habilitado();
		this.propiedades = new ArrayList<Propiedad>();
	}

	public void cobrar(Integer monto) {
		this.capital += monto;
	}

	public void pagar(Integer monto) {
		this.capital -= monto;
		if (this.capital < 0)
			throw new JugadorSinPlataException();
	}

	public Integer getUltimaTirada() {
		return this.dado1.getUltimaTirada() + this.dado2.getUltimaTirada();
	}

	public void mover(Integer casilleros) {
		for (int i = 0; i < casilleros; i++) { // si avanza entra aca
			this.posicion = Posicion.getPosicionSiguiente(this.posicion);
		}

		for (int i = casilleros; i < 0; i++) { // si retrocede entra aca
			this.posicion = Posicion.getPosicionAnterior(this.posicion);
		}
	}

	public void setPosicion(Posicion nuevaPosicion) {
		this.posicion = nuevaPosicion;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public Integer getCapital() {
		return this.capital;
	}

	public Integer getCantidadPropiedades() {
		return this.propiedades.size();
	}

	public void comprarPropiedad(Propiedad propiedad) {
		this.pagar(propiedad.getPrecio());
		this.propiedades.add(propiedad);
	}

	public void caerEnCasillero(Casillero casillero) {
		casillero.recibirJugador(this);
	}

	public boolean puedeEjecutarAcciones() {
		return estado.puedeEjecutarAcciones();
	}

	public boolean puedeMoverse() {
		return estado.puedeMoverse();
	}

	public void iniciarTurno() {
		this.estado.iniciarTurno();
	}

	public void encarcelar() {
		this.estado = new Encarcelado(this);
	}

	public void habilitar() {
		this.estado = new Habilitado();
	}

	public void pagarFianza() {
		if (this.puedeEjecutarAcciones()) {
			this.pagar(Carcel.FIANZA);
			this.estado = new Habilitado();
		}
	}

	public Integer tirar() {
		Integer valor1 = this.dado1.tirar();
		Integer valor2 = this.dado2.tirar();
		return valor1 + valor2;
	}

}
