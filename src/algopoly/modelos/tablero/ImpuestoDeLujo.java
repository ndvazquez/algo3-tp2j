package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

public class ImpuestoDeLujo implements Casillero {

	@Override
	public void recibirJugador(Jugador jugador) {
		
		Integer diezPorCiento = jugador.getCapital() / 10;
		
		jugador.pagar(diezPorCiento);
	}
	
	

}
