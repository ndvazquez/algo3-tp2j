package algopoly.modelos.propiedad;

public class Casa implements Edificio {
	
	private Integer alquiler;
	private Integer precio;
	
	public Casa(Integer precio, Integer alquiler) {
		this.alquiler = alquiler;
		this.precio = precio;
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