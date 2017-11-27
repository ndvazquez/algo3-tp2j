
package algopoly.modelos.tablero.casilleros;

import algopoly.modelos.jugador.Jugador;

public class Carcel implements Casillero {

	public static final String NOMBRE = "CARCEL";

	public static final Integer FIANZA = 45000;

	@Override
	public String getNombre(){
		return NOMBRE;
	}

	@Override
	public void recibirJugador(Jugador jugador) {
		jugador.setCasilleroActual(this);
		jugador.encarcelar();
	}

}
