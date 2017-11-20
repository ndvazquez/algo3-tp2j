package algopoly.modelos.jugador;

import algopoly.modelos.propiedad.Propiedad;
import algopoly.modelos.propiedad.Provincia;
import algopoly.modelos.tablero.Casillero;

import java.util.ArrayList;

public class Jugador {
	
	private static final Integer FIANZA = 45000;
	private static final Integer CAPITAL_INICIAL = 100000;

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
        this.capital = CAPITAL_INICIAL;
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
        if(this.capital - propiedad.getPrecio() > 0){
            this.capital -= propiedad.getPrecio();
            this.propiedades.add(propiedad);
        }
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
	
	public Integer tirar() {
		Integer valor1 = this.dado1.tirar();
		Integer valor2 = this.dado2.tirar();
		return valor1 + valor2;
	}

	public void pagarAlquiler(Jugador jugadorQueCobra, Propiedad propiedad) {
		Integer precioAlquiler = propiedad.getPrecioAlquiler();
		this.capital -= precioAlquiler;
		jugadorQueCobra.incrementarCapital(precioAlquiler);
	}

	public void comprarCasa(Propiedad propiedad) {
		propiedad.construirCasa();
	}
	
	public void comprarHotel(Propiedad propiedad) {
		propiedad.construirHotel();
	}
	
	public Propiedad getPropiedad(Provincia provincia) {
	
		int len = this.propiedades.size();
		
		for ( int i = 0; i < len; i++) {
			Propiedad propiedad = this.propiedades.get(i);
			if ( propiedad.esEstaProvincia(provincia) )
				return propiedad;
		}
		return null;
	}
}
