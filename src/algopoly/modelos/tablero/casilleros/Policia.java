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
		this.carcel.recibirJugador(jugador);
	}
}