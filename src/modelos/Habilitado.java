package modelos;

public class Habilitado implements Estado {

	
	public boolean puedeMoverse() {
		return true;
	}

	public boolean puedeEjecutarAcciones() {
		return true;
	}

	@Override
	public void iniciarTurno() {

	}
}
