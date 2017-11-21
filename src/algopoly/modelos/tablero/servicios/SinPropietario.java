package algopoly.modelos.tablero.servicios;

import algopoly.modelos.jugador.Jugador;

public class SinPropietario implements Estado {

	public void recibirJugador(Jugador jugador, Compania compania) {
		jugador.pagar(compania.getPrecio());
		compania.setPropietario(jugador);
	}
}