package modelos;

import java.util.ArrayList;

public class Jugador {
	
	private final Integer FIANZA = 45000;

    private Integer ultimaTirada;

    private Integer posicion;

    private ArrayList<Casillero> propiedades;

    private Integer capital;

	private boolean puedeEjecutarAcciones;

	private boolean puedeMoverse;

	private int turnosEnCarcel;

	private boolean enCarcel;

    public Jugador() {
        this.posicion = 0;
        this.ultimaTirada = 0;
        //this.capital = 100000;
        this.capital = new Integer(100000);
        this.puedeEjecutarAcciones = true;
        this.puedeMoverse = true;
        this.turnosEnCarcel = 0;
        this.enCarcel = false;
        this.propiedades = new ArrayList<Casillero>();
    }

    public void incrementarCapital(Integer aumento) {
        this.capital += aumento;
    }

    public Integer getUltimaTirada() {
        return this.ultimaTirada;
    }

    public void avanzar(Integer casilleros) {
        this.posicion += casilleros;
    }

    public void retroceder(Integer casilleros) {
        this.posicion -= casilleros;
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

	public void caerEnCasillero(Casillero casillero) {
		casillero.recibirJugador(this);
	}

	public boolean puedeEjecutarAcciones() {
		return this.puedeEjecutarAcciones;
	}

	public boolean puedeMoverse() {
		return this.puedeMoverse;
	}

	public void pagarFianza() {
		
		if(this.puedeEjecutarAcciones && this.capital >= 45000) {
			this.capital -= FIANZA;
			
			this.puedeMoverse = true;
		}
	}

	public void setPuedeEjecutarAcciones(boolean valor) {
		this.puedeEjecutarAcciones = valor;
		
	}

	public void iniciarTurno() {
		
		if(this.enCarcel) {
			this.turnosEnCarcel++;
		}
		
		if(this.turnosEnCarcel > 1) {
			this.puedeEjecutarAcciones = true;
		}
		
	}

	public void encarcelar() {
		this.enCarcel = true;
		this.puedeEjecutarAcciones = false;
		this.puedeMoverse = false;
		
	}
	
	
	
	

}
