package modelos;

import java.util.ArrayList;

public class Jugador {

	private Integer ultimaTirada;

	private Integer posicion;

	private ArrayList<Casillero> propiedades;

	private Integer capital;

	public Jugador() {
		this.posicion = 0;
		this.ultimaTirada = 0;
		this.capital = 100000;
		this.propiedades = new ArrayList<Casillero>();
	}

	public Integer getUltimaTirada() {
		return this.ultimaTirada;
	}

	public void avanzar(Integer casilleros) {
		this.posicion += casilleros;
	}

	public Integer getPosicion() {
		return this.posicion;
	}

	public void setUltimaTirada(Integer ultimaTirada) {
		this.ultimaTirada = ultimaTirada;
	}

	public Integer getCapital() {
		return this.capital;
	}

	public Integer getCantidadPropiedades() {
		return this.propiedades.size();
	}

}
