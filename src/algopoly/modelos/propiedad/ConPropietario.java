package algopoly.modelos.propiedad;

public class ConPropietario implements EstadoPropiedad {
	
	private Integer cantConstrucciones;
	
	public ConPropietario() {
		this.cantConstrucciones = 0;
	}
	
	@Override
	public boolean tienePropietario() {
		return true;
	}

	@Override
	public boolean puedeConstruir() {
		// si es una propiedad simple puede constuir, si no tiene que tener su par
		return false;
	}

	public void adicionarConstruccion() {
		this.cantConstrucciones += 1;
		
	}

}
