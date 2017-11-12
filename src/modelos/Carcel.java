package modelos;

public class Carcel implements Casillero {

	@Override
	public void recibirJugador(Jugador jugador) {
		
		jugador.encarcelar();
		
	}

}
