package modelos;

public class EncarceladoYEsperoUnTurno implements Estado {
	
	public boolean puedeMoverse() {
		
		return false;
	}

	public boolean puedeEjecutarAcciones() {

		return true;
	}

}
