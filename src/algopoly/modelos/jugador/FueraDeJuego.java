package algopoly.modelos.jugador;

public class FueraDeJuego implements Estado {

	@Override
	public void iniciarTurno() {
	}

	@Override
	public void pagarFianza() {

	}

	@Override
	public Integer tirar(Dado dado1, Dado dado2) {
		return 0;
	}

}
