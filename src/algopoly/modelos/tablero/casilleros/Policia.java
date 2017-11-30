package algopoly.modelos.tablero.casilleros;

import algopoly.modelos.jugador.Jugador;

public class Policia implements Casillero {
	
	private Carcel carcel;

	private static final String NOMBRE = "POLICIA";

	public Policia(Carcel carcel) {
		this.carcel = carcel;
	}

	@Override
	public String getNombre(){
		return NOMBRE;
	}

	@Override
	public void recibirJugador(Jugador jugador) {
		jugador.setMensajes(String.format("\tCayó en el casillero %s, es enviado a la CARCEL.\n", NOMBRE));
		this.carcel.recibirJugador(jugador);
	}
}