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
	public Integer getCantidadConstrucciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCantidadConstrucciones() {
	}
}
