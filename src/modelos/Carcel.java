package modelos;

public class Carcel implements Casillero{
	
	public static final Integer POSICION = 5;
	
	@Override
	public void recibirJugador(Jugador jugador) {
		jugador.actualizarPosicion(POSICION);
	}
}
