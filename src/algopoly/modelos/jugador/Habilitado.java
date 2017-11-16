package algopoly.modelos.jugador;

public class Habilitado implements Estado {

    @Override
	public boolean puedeMoverse() {
		return true;
	}

	@Override
	public boolean puedeEjecutarAcciones() {
		return true;
	}

	@Override
	public void iniciarTurno() {

	}
}
