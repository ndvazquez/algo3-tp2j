
package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

public class Carcel implements Casillero {

	public static final Integer FIANZA = 45000;
	
	@Override
	public void recibirJugador(Jugador jugador) {
		jugador.setCasilleroActual(this);
		jugador.encarcelar();
	}

}
