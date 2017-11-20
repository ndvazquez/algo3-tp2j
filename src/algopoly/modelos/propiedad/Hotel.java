package algopoly.modelos.propiedad;

public class Hotel implements Edificio {
	
	private Integer alquiler;
	private Integer precio;
	
	public Hotel(Integer precio, Integer alquiler) {
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
