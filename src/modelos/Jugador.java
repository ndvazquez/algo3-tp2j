package modelos;

import java.util.ArrayList;

public class Jugador {
	
	private final Integer FIANZA = 45000;

    private Integer ultimaTirada;

    private Integer posicion;

    private ArrayList<Casillero> propiedades;

    private Integer capital;

	private Estado estado;

    public Jugador() {
        this.posicion = 0;
        this.ultimaTirada = 0;
        this.capital = new Integer(100000);
        this.estado = new Habilitado();
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
		
		if(this.puedeEjecutarAcciones() && this.capital >= 45000) {
			
			this.capital -= FIANZA;
			this.estado = new Habilitado();
		}
	}
	
}
