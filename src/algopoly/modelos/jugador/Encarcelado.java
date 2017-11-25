package algopoly.modelos.jugador;

import algopoly.modelos.tablero.casilleros.Carcel;

public class Encarcelado implements Estado {
	
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
		
		if(this.turnosEnCarcel == 3) {
			this.jugador.habilitar();
			this.jugador.iniciarTurno();
		}
	}

    public Integer getTurnosEnCarcel() {
        return this.turnosEnCarcel;
    }

	@Override
	public void pagarFianza() {
		if(turnosEnCarcel > 1) {
			jugador.pagar(Carcel.FIANZA);
			jugador.habilitar();
		}
	}

	@Override
	public Integer tirar(Dado dado1, Dado dado2) {
		return TIRADA_NULA;
	}

}
