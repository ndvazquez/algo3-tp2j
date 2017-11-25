package algopoly.modelos.jugador;

import algopoly.modelos.excepciones.JugadorSinPlataException;
import algopoly.modelos.tablero.Casillero;
import algopoly.modelos.tablero.propiedad.Propiedad;
import algopoly.modelos.tablero.propiedad.Provincia;
import algopoly.modelos.tablero.servicios.Compania;

import java.util.ArrayList;
import java.util.Collection;

public class Jugador {

	public static final double RADIO = 20;
	
	private static final Integer CAPITAL_INICIAL = 100000;

	private String nombre;

	private Dado dado1;

	private Dado dado2;

	private Casillero casilleroActual;

	private ArrayList<Propiedad> propiedades;
	
	private ArrayList<Compania> companias;

	private Integer capital;

	private Estado estado;
	
	public Jugador() {
		this.nombre = "Jon Doe";
		this.capital = CAPITAL_INICIAL;
		this.dado1 = new Dado();
		this.dado2 = new Dado();
		this.estado = new Habilitado(this);
		this.propiedades = new ArrayList<>();
		this.companias = new ArrayList<>();
	}

	public void setNombre(String nombre){
	    this.nombre = nombre;
    }
	public String getNombre(){
		return this.nombre;
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

	public boolean sacoDoble(){
		return this.dado1.getUltimaTirada().equals(this.dado2.getUltimaTirada());
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
		while(this.capital - monto < 0 && this.propiedades.size() > 0){
			Propiedad propiedadAVender = this.propiedades.stream().findFirst().get();
			this.venderPropiedad(propiedadAVender);
		}
		this.capital -= monto;
		if (this.capital < 0) {
			throw new JugadorSinPlataException();
		}

	}

	public Integer getCapital() {
		return this.capital;
	}

	public void setCasilleroActual(Casillero casillero) {
		this.casilleroActual = casillero;
	}
	
	public Casillero getCasilleroActual() {
		return this.casilleroActual;
	}

	public Integer getCantidadPropiedades() {
		return this.propiedades.size();
	}

	public Integer getCantidadServicios() { return this.companias.size(); }

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
		
		
		jugadorQueIntercambia.cobrar(propiedadACeder.getPrecio() - propiedadARecibir.getPrecio());
		propiedadARecibir.getPropietario().cobrar(propiedadARecibir.getPrecio() - propiedadACeder.getPrecio());

		propiedadACeder.setPropietario(jugadorQueIntercambia);
		propiedadARecibir.setPropietario(this);

		propiedadACeder.resetPropiedades();
		propiedadARecibir.resetPropiedades();
		
		this.agregarPropiedad(propiedadARecibir);
		jugadorQueIntercambia.agregarPropiedad(propiedadACeder);
		
	}

	public void agregarPropiedad(Propiedad propiedad) {
		this.propiedades.add(propiedad);
		
	}

	public void quitarPropiedad(Propiedad propiedad) {
		this.propiedades.remove(propiedad);
	}

	public void venderPropiedad(Propiedad propiedad){
		this.quitarPropiedad(propiedad);
        propiedad.setSinPropietario();
		this.cobrar(propiedad.getPrecioDeVenta() -  propiedad.getPrecioDeVenta() / 100 * 15);
	}

}
