package algopoly.modelos.propiedad;

public class SinPropietario implements EstadoPropiedad {
	
	@Override
	public boolean tienePropietario() {
		return false;
	}
}
