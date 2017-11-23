package algopoly.modelos.jugador;

public class Habilitado implements Estado {

	Jugador jugador;
	
	public Habilitado(Jugador jugador) {
		
		this.jugador = jugador;
	}
	
	@Override
	public void iniciarTurno() {

	}

	@Override
	public void pagarFianza() {
		
	}

	@Override
	public Integer tirar(Dado dado1, Dado dado2) {
		Integer valor1 = dado1.tirar();
		Integer valor2 = dado2.tirar();
		return valor1 + valor2;
		
	}

	@Override
	public void mover(Jugador jugador, Integer casilleros) {
		for (int i = 0; i < casilleros; i++) { // si avanza entra aca
			Posicion posicionActual = jugador.getPosicion();
			Posicion nuevaPosicion = Posicion.getPosicionSiguiente(posicionActual);
			jugador.setPosicion(nuevaPosicion);
		}

		
		
		for (int i = casilleros; i < 0; i++) { // si retrocede entra aca
			Posicion posicionActual = jugador.getPosicion();
			Posicion nuevaPosicion = Posicion.getPosicionAnterior(posicionActual);
			jugador.setPosicion(nuevaPosicion);
		}
		
	}
}
