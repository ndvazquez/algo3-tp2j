package modelos;

public class Policia implements Casillero {
	
	private Carcel carcel;
	
	public Policia(Carcel carcel) {
		this.carcel = carcel;
	}
	
	@Override
	public void recibirJugador(Jugador jugador) {
		this.carcel.recibirJugador(jugador);
	}
}