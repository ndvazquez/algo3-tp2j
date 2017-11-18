package algopoly.modelos.propiedad;

public class SinPropietario implements EstadoPropiedad {
	
	@Override
	public boolean tienePropietario() {
		return false;
	}

	@Override
	public boolean puedeConstruir() {
		return false;
	}

	@Override
	public void adicionarConstruccion() {
	}
}
