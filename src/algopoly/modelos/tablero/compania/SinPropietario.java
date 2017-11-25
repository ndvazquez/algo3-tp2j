package algopoly.modelos.tablero.compania;

import algopoly.modelos.jugador.Jugador;

public class SinPropietario implements Estado {

	@Override
	public void recibirJugador(Jugador jugador, Compania compania) {
		jugador.comprarCompania(compania);
		compania.setPropietario(jugador);
	}
}
