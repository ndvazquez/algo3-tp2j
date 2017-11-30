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
		jugador.tirar();
		if(this.turnosEnCarcel == 4) {
			this.jugador.habilitar();
			this.jugador.iniciarTurno();
		} else{
			this.jugador.setMensajes(String.format("\t%s sigue encarcelado.\n", this.jugador.getNombre()));
		}
	}

    public Integer getTurnosEnCarcel() {
        return this.turnosEnCarcel;
    }

	@Override
	public void pagarFianza() {
		if(turnosEnCarcel > 1) {
			jugador.pagar(Carcel.FIANZA);
			jugador.setMensajes(String.format("\t%s pagó la fianza.\n", jugador.getNombre()));
			jugador.habilitar();
		}
	}

	@Override
	public Integer tirar(Dado dado1, Dado dado2) {
		dado1.setTiradaNula();
		dado2.setTiradaNula();
		return TIRADA_NULA;
	}

}
