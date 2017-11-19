package algopoly.modelos.propiedad;

public class ConPropietario implements EstadoPropiedad {
	
	@Override
	public boolean tienePropietario() {
		return true;
	}

	@Override
	public boolean puedeConstruir() {
		// si es una propiedad simple puede constuir, si no tiene que tener su par
		// casas y hoteles logica
		return true;
	}
}
