package modelos;

public class Encarcelado implements Estado {
	
	private Integer turnosEnCarcel = 0;
	private Jugador jugador;
	
	public Encarcelado(Jugador jugador) {
		
		this.jugador = jugador;
	}

	public boolean puedeMoverse() {
		return false;
	}

	public boolean puedeEjecutarAcciones() {
		return this.turnosEnCarcel > 1;
	}

	public Integer getTurnosEnCarcel() {
		return this.turnosEnCarcel;
	}

	public void iniciarTurno() {
		this.turnosEnCarcel++;
		
		if(this.turnosEnCarcel == 4) {
			jugador.habilitar();
		}
	}

}
