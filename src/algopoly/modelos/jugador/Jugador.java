package algopoly.modelos.jugador;

import algopoly.modelos.excepciones.JugadorSinPlataException;
import algopoly.modelos.tablero.Carcel;
import algopoly.modelos.tablero.propiedad.Propiedad;
import algopoly.modelos.tablero.propiedad.PropiedadSimple;
import algopoly.modelos.tablero.propiedad.Provincia;
import algopoly.modelos.tablero.servicios.Compania;

import java.util.ArrayList;

public class Jugador {
	
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
		this.estado = new Habilitado(this);
		this.propiedades = new ArrayList<>();
		this.companias = new ArrayList<>();
	}

	public void iniciarTurno() {
		this.estado.iniciarTurno();
	}

	public Integer tirar() {
		return this.estado.tirar(this.dado1, this.dado2);
	}
	
	public Integer getUltimaTirada() {
		return this.dado1.getUltimaTirada() + this.dado2.getUltimaTirada();
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
		this.estado.mover(this, casilleros);
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

	public void encarcelar() {
		this.estado = new Encarcelado(this);
	}

	public void habilitar() {
		this.estado = new Habilitado(this);
	}

	public void pagarFianza() {
		this.estado.pagarFianza();
	}

	public void intercambiarPropiedad(Propiedad propiedadACeder, Propiedad propiedadARecibir, Jugador jugadorQueIntercambia) {
		this.quitarPropiedad(propiedadACeder);
		jugadorQueIntercambia.quitarPropiedad(propiedadARecibir);
		
		propiedadACeder.setPropietario(jugadorQueIntercambia);
		propiedadARecibir.setPropietario(this);
		
		this.agregarPropiedad(propiedadARecibir);
		jugadorQueIntercambia.agregarPropiedad(propiedadACeder);
		
	}

	public void agregarPropiedad(Propiedad propiedad) {
		this.propiedades.remove(propiedad);
		
	}

	public void quitarPropiedad(Propiedad propiedad) {
		this.propiedades.remove(propiedad);
	}

	public void venderPropiedad(Propiedad propiedad) {
		propiedad.vender();
		
	}

}
