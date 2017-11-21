package algopoly.modelos.tablero.propiedad;

public class Vacio implements Edificio {
	
	private Integer alquiler;
	private Integer precio;
	
	public Vacio(Integer precio, Integer alquiler) {
		this.precio = precio;
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