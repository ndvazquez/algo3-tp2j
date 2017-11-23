package algopoly.modelos.jugador;

public interface Estado {
	
	void iniciarTurno();

	void pagarFianza();

	Integer tirar(Dado dado1, Dado dado2);

	void mover(Jugador jugador, Integer casilleros);

}
