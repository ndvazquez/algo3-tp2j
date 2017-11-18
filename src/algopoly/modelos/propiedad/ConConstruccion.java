package algopoly.modelos.propiedad;

public class ConConstruccion implements EstadoPropiedad {

	@Override
	public boolean tienePropietario() {
		return true;
	}

	@Override
	public boolean puedeConstruirCasa() {
		return true;
	}

}
