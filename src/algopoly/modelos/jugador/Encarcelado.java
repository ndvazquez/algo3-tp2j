package algopoly.modelos.jugador;

public class Encarcelado implements Estado {
	
	private static final Integer FIANZA = 45000;
	private static final Integer TIRADA_NULA = 0;
	private Integer turnosEnCarcel;
	private Jugador jugador;
	
	public Encarcelado(Jugador jugador) {
		this.turnosEnCarcel = 0;
		this.jugador = jugador;
	}

	@Override
	public void iniciarTurno() {
		this.turnosEnCarcel++;
		
		if(this.turnosEnCarcel == 4) {
			this.jugador.habilitar();
		}
	}

    public Integer getTurnosEnCarcel() {
        return this.turnosEnCarcel;
    }

	@Override
	public void pagarFianza() {
		if(turnosEnCarcel > 1) {
			jugador.pagar(FIANZA);
			jugador.habilitar();
		}
	}

	@Override
	public Integer tirar(Dado dado1, Dado dado2) {
		return TIRADA_NULA;
	}

	@Override
	public void mover(Jugador jugador, Integer casilleros) {
		
	}

}
