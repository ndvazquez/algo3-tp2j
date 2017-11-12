package modelos;

public class Carcel {
	
	public static final Integer POSICION = 5;
	
	private ArrayList<Jugador> encarcelados = new ArrayList<Jugador>();
	
	public void recibirJugardor(Jugador jugador) {
		jugador.actualizarPosicion(POSICION);
		this.encarcelados.add(jugador);
	}
}
