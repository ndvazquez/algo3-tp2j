
package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.jugador.Posicion;

public class Carcel implements Casillero {

	@Override
	public void recibirJugador(Jugador jugador) {
		jugador.setPosicion(Posicion.CARCEL);
		jugador.encarcelar();
	}

}
