package modelos;

public interface Estado {
	
	public boolean puedeMoverse();
	
	public boolean puedeEjecutarAcciones();

	public void iniciarTurno();

}
