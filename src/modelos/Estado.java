package modelos;

public interface Estado {
	
	boolean puedeMoverse();
	
	boolean puedeEjecutarAcciones();

	void iniciarTurno();

}
