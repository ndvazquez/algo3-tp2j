package algopoly.modelos.propiedad;

public interface EstadoPropiedad {

	boolean tienePropietario();

	boolean puedeConstruir();

	Integer getCantidadConstrucciones();

	void setCantidadConstrucciones();
}