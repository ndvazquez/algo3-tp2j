package modelos;

public class Propiedad implements Casillero {
	
	private Jugador propietario;
	
	public void recibirJugador(Jugador jugador) {
		jugador.comprarPropiedad(this);
		this.propietario = jugador;
	}
	
	public Jugador getPropietario() {
		return this.propietario;
	}
}
