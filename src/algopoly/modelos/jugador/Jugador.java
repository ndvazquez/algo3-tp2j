package algopoly.modelos.jugador;

import algopoly.modelos.excepciones.JugadorSinPlataException;
import algopoly.modelos.tablero.casilleros.Casillero;
import algopoly.modelos.tablero.casilleros.barrios.Barrio;
import algopoly.modelos.tablero.casilleros.barrios.Provincia;
import algopoly.modelos.tablero.casilleros.compania.Compania;

import java.util.ArrayList;
import java.util.Collection;

public class Jugador {

	public static final double RADIO = 20;
	
	private static final Integer CAPITAL_INICIAL = 100000;

	private String nombre;

	private Dado dado1;

	private Dado dado2;

	private Casillero casilleroActual;

	private ArrayList<Barrio> barrios;
	
	private ArrayList<Compania> companias;

	private Integer capital;

	private Estado estado;
	
	public Jugador() {
		this.nombre = "Jon Doe";
		this.capital = CAPITAL_INICIAL;
		this.dado1 = new Dado();
		this.dado2 = new Dado();
		this.estado = new Habilitado(this);
		this.barrios = new ArrayList<>();
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
		Collection<Dado> dados = new ArrayList<>();
		dados.add(dado1);
		dados.add(dado2);
		return dados;
	}
	
	public void cobrar(Integer monto) {
		this.capital += monto;
	}

	public void pagar(Integer monto) {
		while(this.capital - monto < 0 && this.barrios.size() > 0){
			Barrio propiedadAVender = this.barrios.stream().findFirst().get();
			this.venderBarrio(propiedadAVender);
		}
		while(this.capital - monto < 0 && this.companias.size() > 0){
			Compania companiaAVender = this.companias.stream().findFirst().get();
			this.venderCompania(companiaAVender);
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

	public Integer getCantidadBarrios() {
		return this.barrios.size();
	}

	public Integer getCantidadCompanias() { 
		return this.companias.size(); 
	}

	public void comprarBarrio(Barrio barrio) {
		this.pagar(barrio.getPrecio());
		this.barrios.add(barrio);

	}

	public Barrio getBarrio(Provincia provincia) {
		int len = this.barrios.size();
		
		for ( int i = 0; i < len; i++) {
			Barrio barrio = this.barrios.get(i);
			if ( barrio.esEstaProvincia(provincia) ) {
				return barrio;
			}
		}
		return null;
	}

	public void comprarCompania(Compania compania) {
		this.pagar(compania.getPrecio());
		this.agregarCompania(compania);
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

	public void intercambiarPropiedad(Barrio barrioACeder, Barrio barrioARecibir, Jugador jugadorQueIntercambia) {
		this.quitarBarrio(barrioACeder);
		jugadorQueIntercambia.quitarBarrio(barrioARecibir);
		
		
		jugadorQueIntercambia.cobrar(barrioACeder.getPrecio() - barrioARecibir.getPrecio());
		barrioARecibir.getPropietario().cobrar(barrioARecibir.getPrecio() - barrioACeder.getPrecio());

		barrioACeder.setPropietario(jugadorQueIntercambia);
		barrioARecibir.setPropietario(this);

		barrioACeder.resetBarrio();
		barrioARecibir.resetBarrio();
		
		this.agregarBarrio(barrioARecibir);
		jugadorQueIntercambia.agregarBarrio(barrioACeder);
		
	}

	private void agregarBarrio(Barrio barrio) {
		this.barrios.add(barrio);
	}

	private void quitarBarrio(Barrio barrio) {
		this.barrios.remove(barrio);
	}

	public void venderBarrio(Barrio barrio){
		this.quitarBarrio(barrio);
        barrio.setSinPropietario();
		this.cobrar(barrio.getPrecioDeVenta() -  barrio.getPrecioDeVenta() / 100 * 15);
	}

	public void venderCompania(Compania compania){
		this.quitarCompania(compania);
		compania.setSinPropietario();
		this.cobrar(compania.getPrecio() - compania.getPrecio() / 100 * 15);
	}

	private void agregarCompania(Compania compania){
		this.companias.add(compania);
	}

	private void quitarCompania(Compania compania){
		this.companias.remove(compania);
	}

	public Collection<Barrio> getBarrios() {
		return this.barrios;
	}

	public Collection<Compania> getCompanias() {
		return this.companias;
	}

	public void fueraDeJuego() {
		this.estado = new FueraDeJuego();
		this.capital = 0;
		this.companias = new ArrayList<>();
		this.barrios = new ArrayList<>();
	}

	public Boolean sigoEnJuego() {
		return !(this.estado.getClass().equals(FueraDeJuego.class));
	}

}
