package algopoly.modelos.propiedad;

public class Vacio implements Edificio {
	
	private Integer alquiler;
	private Integer precio;
	
	public Vacio(Integer precio, Integer alquiler) {
		this.alquiler = alquiler;
	}
	
	@Override
	public Integer getAlquiler() {
		return this.alquiler;
	}
	
	@Override
	public Integer getPrecio() {
		return this.precio;
	}
}