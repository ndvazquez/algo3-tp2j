package algopoly.modelos.tablero.barrios;

public class Casa implements Inmueble {
	
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