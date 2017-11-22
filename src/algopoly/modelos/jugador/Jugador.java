package algopoly.modelos.jugador;

import algopoly.modelos.excepciones.JugadorSinPlataException;
import algopoly.modelos.tablero.Carcel;
import algopoly.modelos.tablero.propiedad.Propiedad;
import algopoly.modelos.tablero.propiedad.Provincia;
import algopoly.modelos.tablero.servicios.Compania;

import java.util.ArrayList;
import java.util.Collection;

public class Jugador {

	public static final double RADIO = 20;
	
	private static final Integer CAPITAL_INICIAL = 100000;

	private Dado dado1;

	private Dado dado2;

	private Posicion posicion;

	private ArrayList<Propiedad> propiedades;
	
	private ArrayList<Compania> companias;

	private Integer capital;

	private Estado estado;
	
	public Jugador() {
		this.capital = CAPITAL_INICIAL;
		this.posicion = Posicion.SALIDA;
		this.dado1 = new Dado();
		this.dado2 = new Dado();
		this.estado = new Habilitado();
		this.propiedades = new ArrayList<>();
		this.companias = new ArrayList<>();
	}

	public void iniciarTurno() {
		this.estado.iniciarTurno();
		this.mover(this.tirar());
	}

	public Integer tirar() {
		Integer valor1 = this.dado1.tirar();
		Integer valor2 = this.dado2.tirar();
		return valor1 + valor2;
	}
	
	public Integer getUltimaTirada() {
		return this.dado1.getUltimaTirada() + this.dado2.getUltimaTirada();
	}
	
	public Collection<Dado> getUltimaTiradaEnDados() {
		Collection<Dado> dados = new ArrayList<Dado>();
		dados.add(dado1);
		dados.add(dado2);
		return dados;
	}
	
	public void cobrar(Integer monto) {
		this.capital += monto;
	}

	public void pagar(Integer monto) {
		this.capital -= monto;
		if (this.capital < 0) {
			throw new JugadorSinPlataException();
		}
	}

	public Integer getCapital() {
		return this.capital;
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


	public Integer getCantidadPropiedades() {
		return this.propiedades.size();
	}

	public void comprarPropiedad(Propiedad propiedad) {
		if (this.capital - propiedad.getPrecio() > 0) {
			this.capital -= propiedad.getPrecio();
			this.propiedades.add(propiedad);
		}
		this.pagar(propiedad.getPrecio());
		this.propiedades.add(propiedad);
	}

	public Propiedad getPropiedad(Provincia provincia) {
		int len = this.propiedades.size();
		
		for ( int i = 0; i < len; i++) {
			Propiedad propiedad = this.propiedades.get(i);
			if ( propiedad.esEstaProvincia(provincia) ) {
				return propiedad;
			}
		}
		return null;
	}

	public void comprarCompania(Compania compania) {
		this.pagar(compania.getPrecio());
		this.companias.add(compania);
	}
	
	public boolean puedeEjecutarAcciones() {
		return this.estado.puedeEjecutarAcciones();
	}

	public boolean puedeMoverse() {
		return estado.puedeMoverse();
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
}
