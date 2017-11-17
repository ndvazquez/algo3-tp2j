package algopoly.modelos.jugador;

import algopoly.modelos.tablero.Casillero;
import algopoly.modelos.tablero.Propiedad;

import java.util.ArrayList;

public class Jugador {
	
	private static final Integer FIANZA = 45000;

	public static final double RADIO = 20;

    private Dado dado1;
    
    private Dado dado2;

    private Integer posicion;

    private ArrayList<Propiedad> propiedades;

    private Integer capital;

	private Estado estado;

    public Jugador() {
        this.posicion = 0;
        this.dado1 = new Dado();
        this.dado2 = new Dado();
        this.estado = new Habilitado();
        this.capital = 100000;
        this.propiedades = new ArrayList<Propiedad>();
    }

    public void incrementarCapital(Integer aumento) {
        this.capital += aumento;
    }

    public Integer getUltimaTirada() {
        return this.dado1.getUltimaTirada() + this.dado2.getUltimaTirada();
    }

    public void avanzar(Integer casilleros) {
        this.posicion += casilleros;
    }

    public void retroceder(Integer casilleros) {
        this.posicion -= casilleros;
    }

    public void setPosicion(Integer nuevaPosicion){
        this.posicion = nuevaPosicion;
    }
    public Integer getPosicion() {
        return this.posicion;
    }

    public Integer getCapital() {
        return this.capital;
    }

    public Integer getCantidadPropiedades() {
        return this.propiedades.size();
    }

	public void comprarPropiedad(Propiedad propiedad) {
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
		
		this.avanzar(this.tirar());
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

	public Integer tirar() {
		Integer valor1 = this.dado1.tirar();
		Integer valor2 = this.dado2.tirar();
		return valor1 + valor2;
	}

}
