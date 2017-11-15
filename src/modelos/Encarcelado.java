package modelos;

public class Encarcelado implements Estado {
	
	private Integer turnosEnCarcel;
	private Jugador jugador;
	
	public Encarcelado(Jugador jugador) {
		this.turnosEnCarcel = 0;
		this.jugador = jugador;
	}

	@Override
	public boolean puedeMoverse() {
		return false;
	}

	@Override
	public boolean puedeEjecutarAcciones() {
		return this.turnosEnCarcel > 1;
	}

	@Override
	public void iniciarTurno() {
		this.turnosEnCarcel++;
		
		if(this.turnosEnCarcel == 4) {
			jugador.habilitar();
		}
	}

    public Integer getTurnosEnCarcel() {
        return this.turnosEnCarcel;
    }

}
