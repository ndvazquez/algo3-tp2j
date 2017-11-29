package algopoly.modelos.jugador;

import algopoly.modelos.tablero.Tablero;

public class Habilitado implements Estado {

	Jugador jugador;
	
	public Habilitado(Jugador jugador) {
		
		this.jugador = jugador;
	}
	
	@Override
	public void iniciarTurno() {
		int tirada = jugador.tirar();
		for (int i = 0; i < tirada; i++) {
			jugador.setCasilleroActual(Tablero.obtenerTablero().obtenerCasilleroSiguiente(jugador.getCasilleroActual()));
		}
		jugador.setMensajes(String.format("\t%s tiró %d.\n", jugador.getNombre(), tirada));
		jugador.getCasilleroActual().recibirJugador(jugador);
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

}
