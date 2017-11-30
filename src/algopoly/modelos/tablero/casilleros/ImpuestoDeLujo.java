package algopoly.modelos.tablero.casilleros;

import algopoly.modelos.jugador.Jugador;

public class ImpuestoDeLujo implements Casillero {

	private static final String NOMBRE = "IMPUESTO DE LUJO";

	@Override
	public String getNombre(){
		return NOMBRE;
	}
	@Override
	public void recibirJugador(Jugador jugador) {
		
		Integer diezPorCiento = jugador.getCapital() / 10;
		
		jugador.pagar(diezPorCiento);

		jugador.setMensajes(String.format("\tCayó en el casillero %s y pagó %d.\n", NOMBRE, diezPorCiento));
	}
}
