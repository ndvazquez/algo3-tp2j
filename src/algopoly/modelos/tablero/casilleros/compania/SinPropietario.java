package algopoly.modelos.tablero.casilleros.compania;

import algopoly.modelos.jugador.Jugador;

public class SinPropietario implements Estado {

	@Override
	public void recibirJugador(Jugador jugador, Compania compania) {

	}
	
	@Override
	public void comprarCompania(Jugador jugador, Compania compania) {
		jugador.comprarCompania(compania);
		compania.setPropietario(jugador);
	}
}
