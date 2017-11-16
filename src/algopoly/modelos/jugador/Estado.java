package algopoly.modelos.jugador;

public interface Estado {
	
	boolean puedeMoverse();
	
	boolean puedeEjecutarAcciones();

	void iniciarTurno();

}
